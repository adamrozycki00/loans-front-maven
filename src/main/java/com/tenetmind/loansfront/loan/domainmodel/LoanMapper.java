package com.tenetmind.loansfront.loan.domainmodel;

import com.tenetmind.loansfront.currency.domainmodel.CurrencyNameFactory;
import com.tenetmind.loansfront.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    @Autowired
    private LoanService service;


    public LoanDto mapToDto(Loan loan) {
        return new LoanDto(
                loan.getId(),
                loan.getDate(),
                loan.getApplicationDto(),
                loan.getCustomerDto(),
                loan.getCurrencyDto(),
                loan.getAmount(),
                loan.getPeriod(),
                loan.getBaseRate(),
                loan.getMarginRate(),
                loan.getBalance(),
                loan.getAmountToPay(),
                loan.getNumberOfInstallmentsPaid(),
                loan.getStatus(),
                loan.getScheduleDto(),
                loan.getOperationDtos());
    }

    public Loan mapFromDto(LoanDto loanDto) {
        return new Loan(
                loanDto.getId(),
                loanDto.getDate(),
                loanDto.getDate().toLocalDate().toString(),
                loanDto.getApplicationDto(),
                loanDto.getCustomerDto(),
                loanDto.getCustomerDto().getFirstName(),
                loanDto.getCustomerDto().getLastName(),
                loanDto.getCurrencyDto(),
                CurrencyNameFactory.getInstance().makeCurrencyName(loanDto.getCurrencyDto().getName()),
                loanDto.getAmount(),
                loanDto.getAmount().toString(),
                loanDto.getPeriod(),
                loanDto.getBaseRate(),
                loanDto.getMarginRate(),
                loanDto.getBalance(),
                loanDto.getBalance().toString(),
                loanDto.getStatus().equals("New") ? "" : service.getAmountOfNextInstallment(loanDto).toString(),
                loanDto.getAmountToPay(),
                loanDto.getNumberOfInstallmentsPaid(),
                loanDto.getNumberOfInstallmentsPaid().toString(),
                loanDto.getStatus(),
                loanDto.getScheduleDto(),
                loanDto.getOperationDtos());
    }

}