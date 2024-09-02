package com.fakestore.proxyapi.model;

import com.fakestore.proxyapi.dto.GeoLocationDTO;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Embeddable
public class Address {
    private String street;
    private String city;
    private Integer number;
    private String zipcode;
    private GeoLocationDTO location;
}
