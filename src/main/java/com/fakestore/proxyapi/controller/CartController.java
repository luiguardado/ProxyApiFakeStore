package com.fakestore.proxyapi.controller;

import com.fakestore.proxyapi.model.CartShopping;
import com.fakestore.proxyapi.dto.CartShoppingDTO;
import com.fakestore.proxyapi.service.impl.CartServiceImpl;
import com.fakestore.proxyapi.util.MapperUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping
    public Mono<ResponseEntity<CartShoppingDTO>> createCart(@Valid @RequestBody CartShoppingDTO cartdto) {

        CartShopping cartShopping = mapperUtil.map(cartdto, CartShopping.class, "cartMapper");

        return cartService.createCart(cartShopping)
                .map(saveCart -> {
                    CartShoppingDTO savedCartDTO = mapperUtil.map(saveCart, CartShoppingDTO.class, "cartMapper");
                    return ResponseEntity.status(HttpStatus.CREATED).body(savedCartDTO);
                        })
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.CREATED).build());

    }
}
