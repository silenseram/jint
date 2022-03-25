package com.ewmw.client;

import com.ewmw.client.services.logs.LogsApiClient;
import com.ewmw.client.services.logs.LogsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiConfig {

    @Bean
    public LogsService logsService() {
        return new LogsApiClient("http://logsservice:8082", "123");
    }
}
