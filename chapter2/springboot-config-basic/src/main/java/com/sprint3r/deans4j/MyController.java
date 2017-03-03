package com.sprint3r.deans4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Value("${spring.application.name}")
    String appName;

    @Autowired
    Environment environment;

    @Autowired
    MyCustomProperties myCustomProperties;

    @GetMapping("/")
    public String sayHi() {
        String port = environment.getProperty("server.port", "8080");

        return "hello world from " + appName + "\n" +

                "running on port: " + port + "\n" +

                "running with username: " + myCustomProperties.getUsername() + "\n" +
                "and password: " + myCustomProperties.getPassword();
    }
}
