package com.matchesfashion.papi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matchesfashion.papi.domain.Product;
import com.matchesfashion.papi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@RestController
public class ProductsController
{
    @Resource(name = "productService")
    private ProductService productService;

    private ObjectMapper objectMapper;

    @GetMapping(value = "/products/{price}" , produces = "application/json")
    public ResponseEntity<List<Product>> getProducts(@PathVariable int price)
    {
        List<Product> filteredProducts = productService.getAllProductsByPrice(price);
        if (!CollectionUtils.isEmpty(filteredProducts))
        {
            return ResponseEntity.ok(filteredProducts);
        }
        return ResponseEntity.notFound().build();
    }

}
