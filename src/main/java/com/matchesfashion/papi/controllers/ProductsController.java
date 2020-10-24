package com.matchesfashion.papi.controllers;

import com.matchesfashion.papi.domain.Product;
import com.matchesfashion.papi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController
{
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products/{price}" , produces = "application/json")
    public ResponseEntity getProducts(@PathVariable int price)
    {
        List<Product> filteredProducts = productService.getAllProductsByPrice(price);
        if (!CollectionUtils.isEmpty(filteredProducts))
        {
            return ResponseEntity.ok(filteredProducts);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Products Found");
    }

}
