package com.fakestore.proxyapi.dto;

import com.fakestore.proxyapi.model.ProductItem;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder({"orderId", "user", "date", "products"})
public class CartShoppingDTO {

    private Long orderId;

    @NotNull(message = "userId no debe ser nulo")
    private String user;

    @NotNull
    private LocalDate date;

    private List<ProductItem> products;
}
