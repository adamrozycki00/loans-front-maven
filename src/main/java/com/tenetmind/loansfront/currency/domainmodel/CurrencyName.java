package com.tenetmind.loansfront.currency.domainmodel;

public enum CurrencyName {

    PLN("PLN"),
    EUR("EUR"),
    USD("USD"),
    GBP("GBP");

    private final String name;

    CurrencyName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
