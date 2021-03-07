package com.tenetmind.loansfront.currency.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Currency {

    private Long id;
    private CurrencyName name;

    public Currency(CurrencyDto dto) {
        this.name = CurrencyNameFactory.getInstance().makeCurrencyName(dto.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;

        Currency currency = (Currency) o;

        return name.equals(currency.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
