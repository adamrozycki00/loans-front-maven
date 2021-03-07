package com.tenetmind.loansfront.operation.client;

import com.tenetmind.loansfront.operation.client.config.PaymentConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class PaymentClient {

    public static final String PAY_INSTALLMENT = "installment/";
    public static final String MAKE_LOAN = "loan/";

    @Autowired
    private PaymentConfiguration config;

    @Autowired
    private RestTemplate restTemplate;

    public boolean payInstallment(PaymentDto dto) {
        return postForEntity(config.getEndpoint() + PAY_INSTALLMENT, dto);
    }

    public boolean makeLoan(PaymentDto dto) {
        return postForEntity(config.getEndpoint() + MAKE_LOAN, dto);
    }

    private boolean postForEntity(String url, PaymentDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<PaymentDto> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<PaymentDto> response =
                restTemplate.postForEntity(url, entity, PaymentDto.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return true;
        } else {
            System.out.println(response.getStatusCode());
            return false;
        }
    }

}
