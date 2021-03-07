package com.tenetmind.loansfront.loan.client;

import com.tenetmind.loansfront.installment.domainmodel.InstallmentDto;
import com.tenetmind.loansfront.loan.client.config.LoanConfiguration;
import com.tenetmind.loansfront.loan.domainmodel.LoanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanClient {

    @Autowired
    private LoanConfiguration config;

    @Autowired
    private RestTemplate restTemplate;

    public List<LoanDto> getLoanDtos() {
        try {
            LoanDto[] response = restTemplate.getForObject(config.getEndpoint(), LoanDto[].class);
            assert response != null;
            return Arrays.asList(response.clone());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BigDecimal getAmountOfNextInstallment(LoanDto loanDto) {
        final int numberOfNextInstallment = loanDto.getNumberOfInstallmentsPaid() + 1;
        if (numberOfNextInstallment > loanDto.getPeriod()) {
            return BigDecimal.ZERO;
        }
        InstallmentDto nextInstallment = loanDto.getScheduleDto().stream()
                .filter(installment -> installment.getNumber() == numberOfNextInstallment)
                .collect(Collectors.toList()).get(0);
        return nextInstallment.getPrincipal().add(nextInstallment.getInterest());
    }

}
