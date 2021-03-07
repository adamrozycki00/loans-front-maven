package com.tenetmind.loansfront.loan.domainmodel;

import com.tenetmind.loansfront.application.domainmodel.LoanApplicationDto;
import com.tenetmind.loansfront.currency.domainmodel.CurrencyDto;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoanDto {

    private Long id;
    private LocalDateTime date;
    private LoanApplicationDto applicationDto;
    private CustomerDto customerDto;
    private CurrencyDto currencyDto;
    private BigDecimal amount;
    private Integer period;
    private BigDecimal baseRate;
    private BigDecimal marginRate;
    private BigDecimal balance;
    private BigDecimal amountToPay;
    private Integer numberOfInstallmentsPaid;
    private String status;
    private List<InstallmentDto> scheduleDto;
    private List<OperationDto> operationDtos;

}
