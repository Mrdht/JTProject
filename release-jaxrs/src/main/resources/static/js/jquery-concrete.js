'use strict';

(function (factory) {
    if (typeof exports === "object" && typeof module === "object") // CommonJS
        module.exports = factory(require('jquery'));
    else if (typeof define === "function" && define.amd) // AMD
        define(['jquery'], factory);
    else { // Plain browser env
        var self = this || window;
        self.concrete = factory(self.$, self);
    }
}(function ($, self) {


    /**
     * 根据方法参数数量重载方法
     * @param funcName
     * @param function_map
     * @returns {Function}
     */
    var overload = function (funcName, function_map) {

        return function () {
            var key = arguments.length.toString();
            var func = function_map[key];
            if (!func && typeof func !== "function") {
                throw new Error(
                    "not found function: " + funcName + " with " + key + " parameter(s).");
            }
            return func.apply(this, arguments);
        }
    };

    var default_configuration = {
        "root": "",
        "pollingTimeout": 10,
        "onError": function (code, msg) {
            alert("errorCode:" + code + "\nerrorMsg:" + msg);
        },
        "onBroadcast": function (msgId, host, subject, data) {
            console.log(data);
        }
    };


    var configuration = default_configuration;

    var encode = function (any) {
        if (any === undefined || any === null)
            return "";
        else
            return encodeURIComponent(any.toString());
    }

    var localTokenId = null;

    var getTokenId = function(){
        return (configuration.globalTokenKey ?
            localStorage.getItem(configuration.globalTokenKey) : null) || localTokenId;
    }

    var setTokenId = function(tokenId){
        if(!tokenId) return;
        localTokenId = tokenId;
        if(configuration.globalTokenKey){
            localStorage.setItem(configuration.globalTokenKey, tokenId);
        }
    }

    var invoke = function (executable) {
        if (executable) {
            var pathNodes = executable.path.split("/");
            var url = "";
            var param = $.extend({}, executable.param);
            for (var i = 0; i < pathNodes.length; i++) {
                var node = pathNodes[i];
                if (!node && node.trim() === "") continue;
                if (node.charAt(0) === "{") {
                    var key = node.substr(1, node.length - 2);
                    node = param[key];
                    delete param[key];
                }
                url += "/" + encode(node);
            }

            var data = {};
            if (Object.keys(param).length > 0) {
                var obj = Object.keys(param).length === 1 ? param[Object.keys(param)[0]] : param;
                data = {
                    data: typeof(obj) === 'string' ? obj : JSON.stringify(obj)
                }
            }

            var headers = {
                'X-CLIENT-PROVIDER': 'CONCRETE-jQuery',
                'Cache-Control': 'no-cache, no-store'
            };

            var tokenId = getTokenId();
            if(tokenId)headers["CONCRETE-TOKEN-ID"] = tokenId;

            return $.ajax($.extend({}, data, {
                url: configuration.root + url,
                type: executable.method,
                contentType: "application/json; charset=utf-8",
                dataType: executable.dataType,
                headers: headers,
                crossDomain: true,
                xhrFields: {
                    withCredentials: true
                },
                success: function(data, textStatus, request){
                    setTokenId(request.getResponseHeader('CONCRETE-TOKEN-ID'));
                }
            })).fail(function (jx) {
                if (configuration.onError) {
                    var e = jx.responseJSON;
                    if(typeof e === "object"){
                        configuration.onError(e.code,e.msg);
                    } else {
                        configuration.onError(jx.status, jx.responseText);
                    }
                                        // configuration.onError(this, arguments);
                }
            });
        } else {
            throw new Error("executable object is null.");
        }
    };

    var modules = {};

    var clean = function (fullName) {
        var nodes = fullName.split(".");
        var result = undefined;
        for (var i = 0; i < nodes.length; i++) {
            if (nodes[i] && nodes[i].trim() !== "") {
                if (result) {
                    result = result + "." + nodes[i];
                } else {
                    result = nodes[i];
                }
            }
        }
        return result;
    };

    var parseModule = function (fullName) {
        var packageName = undefined;
        var nodes = clean(fullName).split(".");
        for (var i = 0; i < nodes.length - 1; i++) {
            if (packageName) {
                packageName += "." + nodes[i];
            } else {
                packageName = nodes[i];
            }
        }
        return {
            "package": packageName,
            "module": nodes[nodes.length - 1]
        }
    };



    var concrete = {
        "polling": function(){
            try{
                if(!this.pollingStart){
                    var pollingModule = this.module("org.coodex.concrete.jaxrs.Polling");
                    var self = this;
                    var pollingFunc = function(){
                        if(!self.pollingStart) return;
                        pollingModule.polling(configuration.pollingTimeout).done(function(messages){
                            if(configuration.onBroadcast && messages && messages.length > 0){
                                for(var i = 0; i < messages.length; i ++){
                                    var msg = messages[i];
                                    try{
                                        configuration.onBroadcast(msg.id, msg.host, msg.subject, msg.body);
                                    }catch(e){}
                                }
                            }
                            setTimeout(pollingFunc, 10);
                        }).error(function(){
                            this.pollingStart = false;
                        })
                    }
                    this.pollingStart = true;
                    pollingFunc();
                }
            }catch(e){}
        },
        "configure": function (config) {
            configuration = $.extend({}, default_configuration, config);
        },
        "module": function () {
            if (arguments.length == 0 || arguments.length > 2) {
                throw new Error("IllegalArgument, arguments must (moduleName) or (package.moduleName) or (moduleName, package).");
            }
            var fullName = arguments.length === 1 ? arguments[0] : (arguments[1] + "." + arguments[0]);
            var info = parseModule(fullName);
            var m = modules[info.module];
            var module = undefined;
            if (m) {
                if (info.package) {
                    module = m[info.package];
                } else {
                    if (Object.keys(m).length === 1) {
                        module = m[Object.keys(m)[0]];
                    }
                }
            }

            if (module)
                return module;

            throw new Error("No module found. " + fullName);
        }
    };


    /**
     * 注册一个模块，由代码生成器调用
     * @param moduleName 模块名，既Interface的ClassName
     * @param packageName 包名，既Interface的packageName
     * @param module 该模块的所有方法
     */
    var register = function (moduleName, packageName, module) {
        if (!modules[moduleName]) {
            modules[moduleName] = {};
        }
        modules[moduleName][packageName] = module;
    };

    register("DeleteOwnerInfoService", "api", { "deleteOwnerInfo": function (arg0) {return invoke({"path": "/DeleteOwnerInfoService/ownerInfo/{arg0}","param": {"arg0": arg0},"method": "DELETE", "dataType": "json" });}});

    register("ExampleApi", "api", { "add": function (x1, x2) {return invoke({"path": "/Example/add/{x1}/{x2}","param": {"x1": x1, "x2": x2},"method": "GET", "dataType": "json" });}, "aclTest": function () {return invoke({"path": "/Example/aclTest","param": {},"method": "GET", "dataType": "text" });}, "getRandomVeh": function (id) {return invoke({"path": "/Example/vehicles/{id}","param": {"id": id},"method": "GET", "dataType": "text" });}});

    register("SelectAllOwnerInfoService", "api", { "selectAllOwnerInfo": function (arg0) {return invoke({"path": "/SelectAllOwnerInfoService/selectAllOwnerInfo/{arg0}","param": {"arg0": arg0},"method": "GET", "dataType": "json" });}});

    register("SelectOwnerInfo", "api", { "selectOwnerInfo": function (carPersonName, carId) {return invoke({"path": "/SelectOwnerInfo/selectOwnerInfo/{carPersonName}/{carId}","param": {"carPersonName": carPersonName, "carId": carId},"method": "GET", "dataType": "json" });}});

    register("AddChangeInfoService", "api", { "addTimeChangeInfo": function (arg0, arg1, arg2, arg3, arg4, arg5, arg6) {return invoke({"path": "/AddChangeInfoService/addTimeChangeInfo/{arg0}/{arg1}/{arg2}/{arg3}/{arg4}/{arg5}/{arg6}","param": {"arg0": arg0, "arg1": arg1, "arg2": arg2, "arg3": arg3, "arg4": arg4, "arg5": arg5, "arg6": arg6},"method": "GET", "dataType": "json" });}, "addCarOwnerInfoEntityInfo": function (arg0, arg1, arg2) {return invoke({"path": "/AddChangeInfoService/addCarOwnerInfoEntityInfo/{arg0}/{arg1}/{arg2}","param": {"arg0": arg0, "arg1": arg1, "arg2": arg2},"method": "GET", "dataType": "json" });}});

    register("AddOwnerInfoService", "api", { "addOwnerInfo": function (arg0, arg1, arg2, arg3, arg4) {return invoke({"path": "/AddOwnerInfoService/addOwnerInfo/{arg0}/{arg1}/{arg2}/{arg3}/{arg4}","param": {"arg0": arg0, "arg1": arg1, "arg2": arg2, "arg3": arg3, "arg4": arg4},"method": "GET", "dataType": "json" });}});

    register("UpdateOwnerInfoService", "api", { "updateOwnerInfo": function (arg0, arg1, arg2, arg3, arg4, arg5) {return invoke({"path": "/UpdateOwnerInfoService/ownerInfo/{arg0}/{arg1}/{arg2}/{arg3}/{arg4}/{arg5}","param": {"arg0": arg0, "arg1": arg1, "arg2": arg2, "arg3": arg3, "arg4": arg4, "arg5": arg5},"method": "PUT", "dataType": "json" });}});

    register("SelectChangeInfoService", "api", { "selectChangeInfo": function (arg0) {return invoke({"path": "/SelectChangeInfoService/selectChangeInfo/{arg0}","param": {"arg0": arg0},"method": "GET", "dataType": "json" });}});

    if(self){
        self.concrete = concrete;
    }
    return concrete;

}));