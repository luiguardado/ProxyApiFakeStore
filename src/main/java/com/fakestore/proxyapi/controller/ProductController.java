package com.fakestore.proxyapi.controller;

import com.fakestore.proxyapi.dto.ProductDTO;
import com.fakestore.proxyapi.exception.NotFoundException;
import com.fakestore.proxyapi.model.Product;
import com.fakestore.proxyapi.service.iProductService;
import com.fakestore.proxyapi.service.impl.ProductServiceImpl;
import com.fakestore.proxyapi.service.iProductService;
import com.fakestore.proxyapi.util.MapperUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;
    private MapperUtil mapperUtil;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductDTO>> getProductById(@PathVariable String id) throws Exception {

        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<Flux<ProductDTO>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
