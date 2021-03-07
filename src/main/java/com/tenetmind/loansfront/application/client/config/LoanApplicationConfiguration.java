package com.tenetmind.loansfront.application.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationConfiguration {

    private final static String ENDPOINT = "applications/";

    @Value("${source.endpoint}" + ENDPOINT)
    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }

}
