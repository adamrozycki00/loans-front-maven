package com.tenetmind.loansfront.currencyrate.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRateConfiguration {

    private final static String ENDPOINT = "currency_rates/";

    @Value("${source.endpoint}" + ENDPOINT)
    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }

}
