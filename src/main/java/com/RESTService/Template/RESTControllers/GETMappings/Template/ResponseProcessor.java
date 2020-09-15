package com.RESTService.Template.RESTControllers.GETMappings.Template;

import Resources.JSONProcessor;
import org.springframework.stereotype.Service;

// TODO: change service name
@Service(value = "GET*NAME*ResponseProcessor")
public class ResponseProcessor {

    private JSONProcessor jsonProcessor;

    public ResponseProcessor() {
        this.jsonProcessor = new JSONProcessor();
    }

    // TODO: change Object type and specify paramName
    String getResponse(String paramName) {
        Object object = processParameter(paramName);
        String output = jsonProcessor.objectToJSONString(object);
        return output;
    }

    // TODO: change Object type and specify paramName
    private Object processParameter(String paramName) {
        //return processed object
    }

}
