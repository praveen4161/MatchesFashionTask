package com.matchesfashion.papi.services.impl;

import com.matchesfashion.papi.domain.Product;
import com.matchesfashion.papi.repository.ProductRepository;
import com.matchesfashion.papi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProductService implements ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProductsByPrice(int price)
    {
        List<Product> products = productRepository.getProductsFilteredByPrice(price);
        return products;
    }

}
