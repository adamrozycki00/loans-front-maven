package com.tenetmind.loansfront.loan.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoanConfiguration {

    private final static String ENDPOINT = "loans/";

    @Value("${source.endpoint}" + ENDPOINT)
    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }

}
