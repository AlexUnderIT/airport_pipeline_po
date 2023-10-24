package com.example.generalairport.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.generalairport.repository")
@Configuration
public class CommonConfiguration {

}
