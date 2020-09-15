package com.RESTService.Template.RESTControllers.DELETEMappings.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// TODO: specify scope type
@Scope("request")
// TODO: change service name
@RestController(value = "DELETE*NAME*Controller")
class Controller {

    @Autowired
    private ResponseProcessor responseProcessor;

    private List<String> errorsList = new ArrayList<>();

    Controller() { }

    // TODO: specify uriPath
    @DeleteMapping(value = "/uriPath")
    // TODO: specify function name and paramName
    public ResponseEntity<String> delete(@RequestParam(value = "paramName") String paramName) {
        evaluateParameters(paramName);
        if (errorsList.size() > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.join(", ", errorsList));
        } else {
            return ResponseEntity.ok(responseProcessor.getResponse(paramName));
        }
    }

    // TODO: specify paramName and inner function name
    private void evaluateParameters(String paramName) {
        evaluateParameter(paramName);
    }

    // TODO: specify function name and paramName
    private void evaluateParameter(String paramName) {
        if (paramName.length() < 1) {
            // TODO: specify param name
            errorsList.add("At least one *name* must be included in the request");
        } else if (checkParamFormatInvalid(paramName)) {
            // TODO: specify param name
            errorsList.add("Invalid *name* parameter format");
        } else {
            // TODO: do something with param
        }
    }

    // TODO: specify function name and paramName
    private boolean check*name*ParamFormatInvalid(String paramName) {
        // TODO: complete validation test
//        if(paramName invalid){
//            return true;
//        }else{
//            return false
//        }
    }

}
