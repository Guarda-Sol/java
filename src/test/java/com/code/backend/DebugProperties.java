package com.code.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DebugProperties {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @PostConstruct
    public void printProperties() {
        System.out.println("Database URL: " + dbUrl);
    }
}
