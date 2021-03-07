package com.tenetmind.loansfront.currency.domainmodel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CurrencyNameFactory {

    private static CurrencyNameFactory INSTANCE;

    private Set<CurrencyName> names = new HashSet<>();

    public static CurrencyNameFactory getInstance() {
        if (INSTANCE == null)
            INSTANCE = new CurrencyNameFactory();
        return INSTANCE;
    }

    private CurrencyNameFactory() {
        this.names.addAll(Arrays.asList(CurrencyName.values()));
    }

    public final CurrencyName makeCurrencyName(final String currencyName) {
        List<CurrencyName> filtered = names.stream()
                .filter(name -> name.getName().equals(currencyName))
                .collect(Collectors.toList());
        if (filtered.size() > 0)
            return filtered.get(0);
        return null;
    }

}
