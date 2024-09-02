package com.fakestore.proxyapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GeoLocationDTO {

    private String latitude;
    private String longitude;
}
