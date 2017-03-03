package com.sprint3r.deans4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class MyCustomProfilesConfiguration {

    @Bean
    @Profile("default")
    public MyBean myDefaultBean() {
        return new MyBean("default");
    }

    @Bean
    @Profile("cloud")
    public MyBean myBeanForCloud() {
        return new MyBean("cloud");
    }

    @Bean
    @Profile("prod")
    @Primary
    public MyBean myBeanForProd() {
        return new MyBean("prod");
    }
}
