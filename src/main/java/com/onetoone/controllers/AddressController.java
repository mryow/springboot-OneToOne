package com.onetoone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetoone.models.Address;
import com.onetoone.requests.AddressRequest;
import com.onetoone.responses.AddressResponse;
import com.onetoone.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping
    ResponseEntity<AddressResponse> save(@Validated @RequestBody AddressRequest addressRequest) {

        System.out.println(addressRequest.getEmployeeId());
        Address savedAddress = addressService.save(addressRequest.getEmployeeId(), new Address(addressRequest));
        
        return new ResponseEntity<>(new AddressResponse(savedAddress), HttpStatus.CREATED);

    }
}
