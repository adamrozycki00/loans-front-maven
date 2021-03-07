package com.tenetmind.loansfront.application.client;

import com.tenetmind.loansfront.application.client.config.LoanApplicationConfiguration;
import com.tenetmind.loansfront.application.domainmodel.LoanApplicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class LoanApplicationClient {

    @Autowired
    private LoanApplicationConfiguration config;

    @Autowired
    private RestTemplate restTemplate;

    public List<LoanApplicationDto> getApplicationDtos() {
        try {
            LoanApplicationDto[] response = restTemplate.getForObject(config.getEndpoint(), LoanApplicationDto[].class);
            assert response != null;
            return Arrays.asList(response.clone());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public LoanApplicationDto getApplicationDto(Long id) {
        try {
            return restTemplate.getForObject(config.getEndpoint() + id, LoanApplicationDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean createApplication(LoanApplicationDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<LoanApplicationDto> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<LoanApplicationDto> response =
                restTemplate.postForEntity(config.getEndpoint(), entity, LoanApplicationDto.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return true;
        } else {
            System.out.println(response.getStatusCode());
            return false;
        }
    }

    public boolean updateApplication(LoanApplicationDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(singletonList(APPLICATION_JSON));

        HttpEntity<LoanApplicationDto> request = new HttpEntity<>(dto, headers);

        ResponseEntity<LoanApplicationDto> response = restTemplate.exchange(
                config.getEndpoint(),
                PUT,
                request,
                LoanApplicationDto.class,
                1);

        if (response.getStatusCode() == HttpStatus.OK) {
            return true;
        } else {
            System.out.println(response.getStatusCode());
            return false;
        }
    }

    public boolean deleteApplication(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(singletonList(APPLICATION_JSON));

        HttpEntity<LoanApplicationDto> request = new HttpEntity<>(headers);

        ResponseEntity<LoanApplicationDto> response = restTemplate.exchange(
                config.getEndpoint() + id,
                DELETE,
                request,
                LoanApplicationDto.class,
                1);

        if (response.getStatusCode() == HttpStatus.OK) {
            return true;
        } else {
            System.out.println(response.getStatusCode());
            return false;
        }
    }

}
