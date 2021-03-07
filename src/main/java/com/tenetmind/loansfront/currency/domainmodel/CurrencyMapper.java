package com.tenetmind.loansfront.currency.domainmodel;

import com.tenetmind.loansfront.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {

    @Autowired
    private CurrencyService service;

    public CurrencyDto mapToDto(final Currency entity) {
        return new CurrencyDto(
                service.get(entity.getName().getName()).getId(),
                entity.getName().getName());
    }

}
