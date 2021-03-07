package com.tenetmind.loansfront.view;

import com.tenetmind.loansfront.loan.domainmodel.Loan;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class LoanForm extends FormLayout {

    private final MainView mainView;
    private final TextField nextInstallmentString = new TextField("Next installment");

    private final Button makeLoan = new Button("Make loan");
    private final Button payInstallment = new Button("Pay installment");

    private final Binder<Loan> binder = new Binder<>(Loan.class);

    public LoanForm(MainView mainView) {
        this.mainView = mainView;
        HorizontalLayout buttons = new HorizontalLayout(makeLoan, payInstallment);
        makeLoan.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        payInstallment.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        add(nextInstallmentString, buttons);
        binder.bindInstanceFields(this);

        makeLoan.addClickListener(e -> makeLoan());
        payInstallment.addClickListener(e -> payInstallment());
    }

    public void setLoan(Loan loan) {
        binder.setBean(loan);

        if (loan == null) {
            setVisible(false);
        } else {
            setVisible(true);
            if ("Active".equals(loan.getStatus())) {
                nextInstallmentString.focus();
            }
        }
    }

    public void makeLoan() {
        Loan loan = binder.getBean();
        mainView.getLoanService().makeLoan(loan);
        mainView.refresh();
        setLoan(null);
    }

    public void payInstallment() {
        Loan loan = binder.getBean();
        mainView.getLoanService().payInstallment(loan);
        mainView.refresh();
        setLoan(null);
    }

}
