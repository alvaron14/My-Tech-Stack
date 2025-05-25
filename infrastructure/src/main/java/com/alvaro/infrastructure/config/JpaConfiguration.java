package com.alvaro.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration(proxyBeanMethods = false)
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.alvaro.infrastructure")
@EntityScan(basePackages = "com.alvaro.infrastructure")
@EnableTransactionManagement
public class JpaConfiguration {

}
