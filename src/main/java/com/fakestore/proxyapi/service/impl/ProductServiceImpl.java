package com.fakestore.proxyapi.service.impl;

import com.fakestore.proxyapi.dto.ProductDTO;
import com.fakestore.proxyapi.exception.NotFoundException;
import com.fakestore.proxyapi.model.Product;
import com.fakestore.proxyapi.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.fakestore.proxyapi.util.MapperUtil;

@Service
public class ProductServiceImpl implements iProductService {

    private final WebClient webClient;

    @Autowired
    private MapperUtil mapperUtil;

    public ProductServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://fakestoreapi.com").build();
    }

    @Override
    public Mono<ProductDTO> getProductById(String id) throws Exception {
        return  webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .map(product -> mapperUtil.map(product, ProductDTO.class, "productMapper"));

    }

    @Override
    public Flux<ProductDTO> getAllProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class)
                .map(product -> mapperUtil.map(product, ProductDTO.class, "productMapper"));
    }

}
