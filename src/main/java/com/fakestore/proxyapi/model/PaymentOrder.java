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
public class PaymentOrder {

    @NotNull
    private Long orderId;
    @NotNull
    private String userId;

    private LocalDateTime paymentDate;

    @NotNull
    private List<ProductItem> products;
    @NotNull
    private Double totalProductsAmount;
    @NotNull
    private Double shipment;

    private Double discount;
    private Double totalBillAmount;

}
