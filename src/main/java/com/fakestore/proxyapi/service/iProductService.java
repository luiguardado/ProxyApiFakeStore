package com.fakestore.proxyapi.service;

import com.fakestore.proxyapi.dto.ProductDTO;
import com.fakestore.proxyapi.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface iProductService {
    Mono<ProductDTO> getProductById(String id) throws Exception;
    Flux<ProductDTO> getAllProducts();
}
