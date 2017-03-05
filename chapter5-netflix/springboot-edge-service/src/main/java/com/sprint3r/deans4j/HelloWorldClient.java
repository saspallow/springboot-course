package com.sprint3r.deans4j;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("hello-world-service")
public interface HelloWorldClient {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    String getGreeting(@PathVariable("name") String name);
}
