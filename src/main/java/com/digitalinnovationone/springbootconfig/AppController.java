package com.digitalinnovationone.springbootconfig;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.message}")
    private String appMessage;

    @Value("${var: nenhuma.}")
    private String variableEnvironment;

    @GetMapping("/")
    public String getAppMessage()
    {
        return appMessage;
    }


    @GetMapping("/var")
    public String getVariable()
    {
        return "variable is defined"+variableEnvironment;
    }
}
