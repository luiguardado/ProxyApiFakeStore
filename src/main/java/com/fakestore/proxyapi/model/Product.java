package com.fakestore.proxyapi.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.boot.convert.DataSizeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @NotNull
    @EqualsAndHashCode.Include
    private String id;

    @NotNull
    private String title;

    @NotNull
    private double price;

    @NotNull
    private String description;

    private String image;

    @NotNull
    private String category;

}
