package com.onetoone.responses;

import com.onetoone.models.Address;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressResponse {
    private Long id;
    private Long employeeId;
    private String city;
    private String street;

    public AddressResponse(Address address) {
        setId(address.getId());
        setCity(address.getCity());
        setEmployeeId(address.getEmployee().getId());
        setStreet(address.getStreet());
    }
}
