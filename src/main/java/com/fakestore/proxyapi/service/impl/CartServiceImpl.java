package com.fakestore.proxyapi.service.impl;

import com.fakestore.proxyapi.model.CartShopping;
import com.fakestore.proxyapi.service.iCartService;
import com.fakestore.proxyapi.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CartServiceImpl implements iCartService {

    private final WebClient webClient;

    @Autowired
    private MapperUtil mapperUtil;

    public CartServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://fakestoreapi.com").build();
    }

    @Override
    public Mono<CartShopping> createCart(CartShopping cart) {
        return webClient.post()
                .uri("carts/")
                .bodyValue(cart)
                .retrieve()
                .bodyToMono(CartShopping.class);
    }
}
