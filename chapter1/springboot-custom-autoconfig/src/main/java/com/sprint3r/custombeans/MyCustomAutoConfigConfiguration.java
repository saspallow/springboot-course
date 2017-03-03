package com.sprint3r.custombeans;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
public class MyCustomAutoConfigConfiguration {

    @Bean
    @ConditionalOnClass(Connection.class)
    @ConditionalOnProperty(name = "my-bean.enabled", matchIfMissing = true)
    MyCustomBean myCustomBean() {
        return new MyCustomBean();
    }

    @Bean
    @ConditionalOnMissingBean(JdbcTemplate.class)
    @ConditionalOnBean(DataSource.class)
    JdbcTemplate myCustomJdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }

}
