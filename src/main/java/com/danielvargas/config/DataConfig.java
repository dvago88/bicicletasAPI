package com.danielvargas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.danielvargas.repository")
@PropertySource("application.properties")
@EnableTransactionManagement
public class DataConfig {


}
