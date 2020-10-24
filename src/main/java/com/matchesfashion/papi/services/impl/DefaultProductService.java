package com.matchesfashion.papi.services.impl;

import com.matchesfashion.papi.domain.Product;
import com.matchesfashion.papi.repository.ProductRepository;
import com.matchesfashion.papi.services.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("productService")
public class DefaultProductService implements ProductService
{
    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProductsByPrice(int price)
    {
        return productRepository.getProductsFilteredByPrice(price);
    }

}
