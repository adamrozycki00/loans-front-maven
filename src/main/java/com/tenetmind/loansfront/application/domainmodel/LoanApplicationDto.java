package com.tenetmind.loansfront.application.domainmodel;

import com.tenetmind.loansfront.currency.domainmodel.CurrencyDto;
import com.tenetmind.loansfront.customer.domainmodel.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoanApplicationDto implements Serializable {

    private Long id;
    private LocalDateTime date;
    private CustomerDto customerDto;
    private CurrencyDto currencyDto;
    private BigDecimal amount;
    private Integer period;
    private BigDecimal marginRate;
    private String status;

}
