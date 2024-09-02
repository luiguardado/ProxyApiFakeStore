package com.fakestore.proxyapi.service;

import com.fakestore.proxyapi.model.CartShopping;
import reactor.core.publisher.Mono;

public interface iCartService {

    Mono<CartShopping> createCart(CartShopping cart);
}
