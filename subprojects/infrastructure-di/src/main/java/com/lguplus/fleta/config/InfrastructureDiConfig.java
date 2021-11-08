package com.lguplus.fleta.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"com.lguplus.fleta"})
public class InfrastructureDiConfig {
}
