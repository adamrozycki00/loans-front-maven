package com.tenetmind.loansfront.currency.service;

import com.tenetmind.loansfront.currency.client.CurrencyClient;
import com.tenetmind.loansfront.currency.domainmodel.CurrencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyClient client;

    public CurrencyDto get(String name) {
        List<CurrencyDto> currencyDtos = getAll().stream()
                .filter(cur -> name.equals(cur.getName()))
                .collect(Collectors.toList());
        if (currencyDtos.size() > 0) {
            return currencyDtos.get(0);
        }
        return null;
    }

    public List<CurrencyDto> getAll() {
        return client.getCurrencyDtos();
    }

}