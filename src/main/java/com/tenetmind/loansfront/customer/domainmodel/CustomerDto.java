package com.tenetmind.loansfront.customer.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;

}
