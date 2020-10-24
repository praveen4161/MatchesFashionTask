package com.matchesfashion.papi.repository;

import com.matchesfashion.papi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{

    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> getProductsFilteredByPrice(int price);

}
