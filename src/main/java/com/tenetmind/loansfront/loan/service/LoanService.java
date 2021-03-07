package com.tenetmind.loansfront.loan.service;

import com.tenetmind.loansfront.currencyrate.client.CurrencyRateClient;
import com.tenetmind.loansfront.loan.client.LoanClient;
import com.tenetmind.loansfront.loan.domainmodel.Loan;
import com.tenetmind.loansfront.loan.domainmodel.LoanDto;
import com.tenetmind.loansfront.loan.domainmodel.LoanMapper;
import com.tenetmind.loansfront.operation.client.PaymentClient;
import com.tenetmind.loansfront.operation.client.PaymentDto;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final String NEW = "New";
    private final String ACTIVE = "Active";

    @Autowired
    private LoanClient loanClient;

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private CurrencyRateClient currencyRateClient;

    @Autowired
    private LoanMapper mapper;

    public List<Loan> getAll() {
        return loanClient.getLoanDtos().stream()
                .map(mapper::mapFromDto)
                .collect(Collectors.toList());
    }

    public BigDecimal getAmountOfNextInstallment(LoanDto loanDto) {
        return loanClient.getAmountOfNextInstallment(loanDto);
    }

    public void makeLoan(Loan loan) {
        boolean currencyRateIsUpToDate = checkForUpToDateRate(loan.getCurrencyName().getName());
        if (!currencyRateIsUpToDate) {
            Notification.show("No up-to-date currency rate for the loan");
        } else {
            if (NEW.equals(loan.getStatus())) {
                PaymentDto paymentDto = new PaymentDto(LocalDate.now(), loan.getId());
                paymentClient.makeLoan(paymentDto);
                loan.setNextInstallmentString(getAmountOfNextInstallment(mapper.mapToDto(loan)).toString());
            } else {
                Notification.show("The loan has already been made");
            }
        }
    }

    public void payInstallment(Loan loan) {
        boolean currencyRateIsUpToDate = checkForUpToDateRate(loan.getCurrencyName().getName());
        if (!currencyRateIsUpToDate) {
            Notification.show("No up-to-date currency rate for the loan");
        } else {
            if (ACTIVE.equals(loan.getStatus()) && loan.getBalance().compareTo(BigDecimal.ZERO) > 0) {
                PaymentDto paymentDto = new PaymentDto(LocalDate.now(), loan.getId(),
                        loan.getCurrencyName().getName(), new BigDecimal(loan.getNextInstallmentString()));
                paymentClient.payInstallment(paymentDto);
            } else {
                Notification.show("You can only pay installment for active loans");
            }
        }
    }

    private boolean checkForUpToDateRate(String currencyName) {
        if ("PLN".equals(currencyName)) {
            return true;
        }
        return currencyRateClient.checkForUpToDateRate(currencyName);
    }

}
