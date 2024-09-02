package com.fakestore.proxyapi.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CartShopping {
    
    private Long id;

    @NotNull
    private String userId;

    @NotNull
    private LocalDate date;

    private List<ProductItem> products;
}
