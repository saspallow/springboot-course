package com.sprint3r.deans4j;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloServiceGatewayController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloWorldClient helloWorldClient;

    @GetMapping(value = "/json-rest-template/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Hello hello(@PathVariable("name") String name) {
        String value = restTemplate.getForObject("http://hello-world-service/{name}", String.class, name);
        return new Hello(value + " from restTemplate");
    }

    @GetMapping(value = "/json-feign/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Hello helloFromFeign(@PathVariable("name") String name) {
        String value = helloWorldClient.getGreeting(name);
        return new Hello(value + " from feign");
    }

    @HystrixCommand(fallbackMethod = "myDefaultAnswer")
    @GetMapping(value = "/json-feign-circuit-breaker/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Hello helloFromFeignWithCircuitBreaker(@PathVariable("name") String name) {
        String value = helloWorldClient.getGreeting(name);
        return new Hello(value + " from feign with circuit breaker");
    }

    private Hello myDefaultAnswer(String name) {
        return new Hello("สวัสดีครับ " + name);
    }



    @Data
    public static class Hello {
        private final String hello;

        Hello(String hello) {
            this.hello = hello;
        }
    }
}
