package impl;

import api.ExampleApi;
import org.coodex.concrete.apitools.API;
import org.coodex.concrete.apitools.jaxrs.service.ServiceDocRender;

import java.io.IOException;

public class APIGenerator {

    public static void main(String [] args) throws IOException {
        API.generate(ServiceDocRender.RENDER_NAME, "/doc/restful",
                ExampleApi.class.getPackage().getName());
    }
}