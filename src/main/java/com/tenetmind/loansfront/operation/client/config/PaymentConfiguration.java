package com.tenetmind.loansfront.operation.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentConfiguration {

    private final static String ENDPOINT = "operations/payments/";

    @Value("${source.endpoint}" + ENDPOINT)
    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }

}
