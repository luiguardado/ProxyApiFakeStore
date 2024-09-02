package com.fakestore.proxyapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTO {
    private String street;
    private String city;
    private Integer number;
    private String zipcode;
    private GeoLocationDTO location;
}
