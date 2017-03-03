package com.sprint3r.deans4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBeanController {

    @Autowired
    MyBean myBean;

    @GetMapping("/my-bean")
    public String value() {
        return myBean.getValue();
    }
}
