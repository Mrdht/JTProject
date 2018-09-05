package impl;

import api.ExampleApi;
import org.coodex.concrete.apitools.API;
import org.coodex.concrete.apitools.jaxrs.jquery.JQueryPromisesCodeRender;

import java.io.IOException;

public class JQuerySDKGenerator {

    public static void main(String [] args) throws IOException {
        String projectPath = "D:/practice/JTProject/release-jaxrs";// 自行修改
        API.generate(JQueryPromisesCodeRender.RENDER_NAME,
                projectPath + "/src/main/resources/static/js",
                ExampleApi.class.getPackage().getName());
    }
}