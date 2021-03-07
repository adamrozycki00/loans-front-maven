package com.tenetmind.loansfront.currency.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConfiguration {

    private final static String ENDPOINT = "currencies/";

    @Value("${source.endpoint}" + ENDPOINT)
    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }

}
