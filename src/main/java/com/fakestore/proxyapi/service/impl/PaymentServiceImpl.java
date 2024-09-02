package com.fakestore.proxyapi.service.impl;

import com.fakestore.proxyapi.dto.PaymentOrderDTO;
import com.fakestore.proxyapi.model.PaymentOrder;
import com.fakestore.proxyapi.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl {

    @Autowired
    private MapperUtil mapperUtil;

    public Mono<PaymentOrderDTO> processPayment(PaymentOrder payment) {
        PaymentOrderDTO paymentdto = new PaymentOrderDTO();

        paymentdto = mapperUtil.map(payment, PaymentOrderDTO.class);
        paymentdto.setPaymentDate(LocalDateTime.now());
        paymentdto.setDiscount(18.00);
        paymentdto.setShipment(10.00);
        paymentdto.setTotalBillAmount(payment.getTotalProductsAmount()
                + paymentdto.getShipment()
                - paymentdto.getDiscount());

        return Mono.just(paymentdto);
    }
}
