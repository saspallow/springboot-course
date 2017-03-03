package com.sprint3r.deans4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    Iterable<Product> productList() {
        System.out.println("hello");
        return repository.findAll();
    }

    @GetMapping("/cpu")
    Iterable<Product> cpu() {
        return jdbcTemplate.query("select * from Product p WHERE p.type = 'CPU'", (rs, rowNum) ->
                new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("description"))
                );
    }
}
