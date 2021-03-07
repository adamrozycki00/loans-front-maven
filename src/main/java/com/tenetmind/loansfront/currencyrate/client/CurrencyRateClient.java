package com.tenetmind.loansfront.currencyrate.client;

import com.tenetmind.loansfront.currencyrate.client.config.CurrencyRateConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyRateClient {

    @Autowired
    private CurrencyRateConfiguration config;

    @Autowired
    private RestTemplate restTemplate;

    public boolean checkForUpToDateRate(String currencyName) {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Boolean> entity = new HttpEntity<>(headers);

        ResponseEntity<Boolean> response =
                restTemplate.postForEntity(config.getEndpoint() + "uptodate/" + currencyName,
                        entity, Boolean.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            System.out.println(response.getStatusCode());
            return false;
        }
    }

}
