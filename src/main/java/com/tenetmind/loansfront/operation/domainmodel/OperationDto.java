package com.tenetmind.loansfront.operation.domainmodel;

import com.tenetmind.loansfront.currency.domainmodel.CurrencyDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OperationDto {

    private Long id;
    private LocalDate date;
    private Long loanId;
    private String type;
    private CurrencyDto currencyDto;
    private BigDecimal amount;
    private BigDecimal plnAmount;

}
