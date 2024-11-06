package com.waffle.wfchat.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class JpaConfig {
    @Value("${spring.datasource.url}")
    private String url;

    @PostConstruct
    public void init() {
        log.info("datasource url {}", url);
    }
}
