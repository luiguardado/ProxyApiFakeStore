package com.fakestore.proxyapi.controller;

import com.fakestore.proxyapi.dto.PaymentOrderDTO;
import com.fakestore.proxyapi.model.PaymentOrder;
import com.fakestore.proxyapi.service.impl.PaymentServiceImpl;
import com.fakestore.proxyapi.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping
    public Mono<ResponseEntity<PaymentOrderDTO>> processPayment(@RequestBody PaymentOrderDTO paymentdto) {

        PaymentOrder paymentOrder = mapperUtil.map(paymentdto, PaymentOrder.class, "paymentMapper");

        return paymentService.processPayment(paymentOrder)
                .map(savePayment -> {
                    PaymentOrderDTO savePaymentDTO = mapperUtil.map(savePayment, PaymentOrderDTO.class, "paymentMapper");
                    return ResponseEntity.status(HttpStatus.CREATED).body(savePaymentDTO);
                        })
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.CREATED).build());

    }
}
