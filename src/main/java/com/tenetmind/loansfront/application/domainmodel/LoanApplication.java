package com.tenetmind.loansfront.application.domainmodel;

import com.tenetmind.loansfront.currency.domainmodel.CurrencyDto;
import com.tenetmind.loansfront.currency.domainmodel.CurrencyName;
import com.tenetmind.loansfront.currency.domainmodel.CurrencyNameFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoanApplication {

    private String id;
    private LocalDateTime date;
    private String dateString;
    private String customerId;
    private String firstName;
    private String lastName;
    private String pesel;
    private CurrencyDto currency;
    private CurrencyName currencyName;
    private String amount;
    private String period;
    private String marginRate;
    private String status;

    public LoanApplication(LoanApplicationDto dto) {
        this.id = dto.getId() == null ? null : dto.getId().toString();
        this.date = dto.getDate();
        this.dateString = dto.getDate().toLocalDate().toString();
        this.customerId = dto.getCustomerDto().getId().toString();
        this.firstName = dto.getCustomerDto().getFirstName();
        this.lastName = dto.getCustomerDto().getLastName();
        this.pesel = dto.getCustomerDto().getPesel();
        this.currency = dto.getCurrencyDto();
        this.currencyName = CurrencyNameFactory.getInstance().makeCurrencyName(dto.getCurrencyDto().getName());
        this.amount = dto.getAmount().toString();
        this.period = dto.getPeriod().toString();
        this.marginRate = dto.getMarginRate().toString();
        this.status = dto.getStatus();
    }

}
