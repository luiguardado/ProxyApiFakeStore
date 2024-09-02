package com.fakestore.proxyapi.dto;

import com.fakestore.proxyapi.model.ProductItem;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class PaymentOrderDTO {

    @NotNull
    private Long orderId;
    @NotNull
    private String userId;
    @NotNull
    private String clientLegalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
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
