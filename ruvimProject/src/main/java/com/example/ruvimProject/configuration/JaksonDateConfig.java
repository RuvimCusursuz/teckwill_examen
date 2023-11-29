package com.example.ruvimProject.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;
@Configuration
public class JaksonDateConfig {
        @Bean
        public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
            Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
            builder.dateFormat(new SimpleDateFormat("yyyy.MM.dd"));
            return builder;
        }
    }

