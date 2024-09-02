package com.fakestore.proxyapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GeoLocation {

    private String latitude;
    private String longitude;
}
