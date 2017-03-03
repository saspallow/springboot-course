package com.sprint3r.deans4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MyController {

    @Autowired
    MyCustomProperties myCustomProperties;

    @GetMapping("/")
    public String sayHi() {

        return "running with username: " + myCustomProperties.getUsername() + "\n" +
                "and password: " + myCustomProperties.getPassword();
    }
}
