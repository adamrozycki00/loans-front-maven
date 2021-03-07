package com.tenetmind.loansfront.loan.domainmodel;

import com.tenetmind.loansfront.application.domainmodel.LoanApplicationDto;
import com.tenetmind.loansfront.currency.domainmodel.CurrencyDto;
import com.tenetmind.loansfront.currency.domainmodel.CurrencyName;
import com.tenetmind.loansfront.customer.domainmodel.CustomerDto;
import com.tenetmind.loansfront.installment.domainmodel.InstallmentDto;
import com.tenetmind.loansfront.operation.domainmodel.OperationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Loan {

    private Long id;
    private LocalDateTime date;
    private String dateString;
    private LoanApplicationDto applicationDto;
    private CustomerDto customerDto;
    private String firstNameString;
    private String lastNameString;
    private CurrencyDto currencyDto;
    private CurrencyName currencyName;
    private BigDecimal amount;
    private String amountString;
    private Integer period;
    private BigDecimal baseRate;
    private BigDecimal marginRate;
    private BigDecimal balance;
    private String balanceString;
    private String nextInstallmentString;
    private BigDecimal amountToPay;
    private Integer numberOfInstallmentsPaid;
    private String numberOfInstallmentsPaidString;
    private String status;
    private List<InstallmentDto> scheduleDto;
    private List<OperationDto> operationDtos;

}