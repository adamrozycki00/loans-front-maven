package com.tenetmind.loansfront.currencyrate.domainmodel;

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
public class CurrencyRateDto {

    private Long id;
    private String name;
    private LocalDate date;
    private CurrencyDto currencyDto;
    private BigDecimal rate;

}
