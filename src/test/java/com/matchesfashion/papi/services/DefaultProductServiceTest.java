package com.matchesfashion.papi.services;

import com.matchesfashion.papi.domain.Product;
import com.matchesfashion.papi.repository.ProductRepository;
import com.matchesfashion.papi.services.impl.DefaultProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class DefaultProductServiceTest
{
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private DefaultProductService productService;

    @Before
    public void setUp() {
        Product sampleProduct = new Product();
        sampleProduct.setId(10596);
        sampleProduct.setPrice(10);
        Mockito.when(productRepository.getProductsFilteredByPrice(Mockito.anyInt()))
                .thenReturn(Arrays.asList(sampleProduct));
    }

    @Test
    public void testGetAllFilteredProducts()
    {
        List<Product> products = productService.getAllProductsByPrice(10);
        assertEquals(10, products.iterator().hasNext()? products.iterator().next().getPrice(): 0);
    }
}
