package com.fakestore.proxyapi.config;


import com.fakestore.proxyapi.dto.PaymentOrderDTO;
import com.fakestore.proxyapi.dto.ProductDTO;
import com.fakestore.proxyapi.model.CartShopping;
import com.fakestore.proxyapi.dto.CartShoppingDTO;
import com.fakestore.proxyapi.model.PaymentOrder;
import com.fakestore.proxyapi.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper() { return new ModelMapper(); }

    @Bean("productMapper")
    public ModelMapper productMapper(){

        ModelMapper mapper = new ModelMapper();

        mapper.createTypeMap(Product.class, ProductDTO.class)
               .addMapping(Product::getPrice, ProductDTO::setCost)
               .addMapping(Product::getTitle, ProductDTO::setName);

        return mapper;

    }

    @Bean("cartMapper")
    public ModelMapper cartMapper(){

        ModelMapper mapper = new ModelMapper();

        mapper.createTypeMap(CartShopping.class, CartShoppingDTO.class)
                .addMapping(CartShopping::getId, CartShoppingDTO::setOrderId)
                .addMapping(CartShopping::getUserId, CartShoppingDTO::setUser);

        mapper.createTypeMap(CartShoppingDTO.class, CartShopping.class)
                .addMapping(CartShoppingDTO::getOrderId, CartShopping::setId)
                .addMapping(CartShoppingDTO::getUser, CartShopping::setUserId);
        return mapper;
    }

    @Bean("paymentMapper")
    public ModelMapper paymentMapper()
    {
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(PaymentOrderDTO.class, PaymentOrder.class);
        return mapper;
    }
}
