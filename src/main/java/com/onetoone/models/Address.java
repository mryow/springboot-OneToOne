package com.onetoone.models;


import com.onetoone.requests.AddressRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String city;

    @Column 
    private String street;

    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Address (AddressRequest addressRequest){
        this.setStreet(addressRequest.getStreet());
        this.setCity(addressRequest.getCity());
    }
}
