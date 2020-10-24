package com.matchesfashion.papi.services;

import com.matchesfashion.papi.domain.Product;

import java.util.List;

public interface ProductService
{
    List<Product> getAllProductsByPrice(int price);

}
