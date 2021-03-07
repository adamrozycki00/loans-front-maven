package com.tenetmind.loansfront.currency.client;

import com.tenetmind.loansfront.currency.client.config.CurrencyConfiguration;
import com.tenetmind.loansfront.currency.domainmodel.CurrencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CurrencyClient {

    @Autowired
    private CurrencyConfiguration config;

    @Autowired
    private RestTemplate restTemplate;

    public List<CurrencyDto> getCurrencyDtos() {
        try {
            CurrencyDto[] response = restTemplate.getForObject(config.getEndpoint(), CurrencyDto[].class);
            assert response != null;
            return Arrays.asList(response.clone());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
