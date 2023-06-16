package com.onetoone.requests;

import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AddressRequest {
    
    @Nullable
    private Long id;
    private Long employeeId;
    private String city;
    private String street;
}
