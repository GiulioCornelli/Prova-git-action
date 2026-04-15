package com.ttf.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ttf.data.Product;
import com.ttf.repository.ProductRepo;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock private ProductRepo repo;

    @InjectMocks private ProductService service;

    private Product testProduct;

    @BeforeEach
    void setUp() {
        testProduct = new Product(1L, "Test Product", "Test Description", 99.99f);
    }

    @Test
    void gettAll_returnsListOfProducts() {
        List<Product> expected = Arrays.asList(testProduct);
        when(repo.findAll()).thenReturn(expected);

        List<Product> result = service.gettAll();

        assertEquals(expected, result);
        verify(repo, times(1)).findAll();
    }

    @Test
    void gettAll_returnsEmptyList_whenNoProducts() {
        when(repo.findAll()).thenReturn(List.of());

        List<Product> result = service.gettAll();

        assertTrue(result.isEmpty());
    }

    @Test
    void InsertOne_returnsTrue_onSuccess() {
        when(repo.save(testProduct)).thenReturn(testProduct);

        boolean result = service.InsertOne(testProduct);

        assertTrue(result);
        verify(repo, times(1)).save(testProduct);
    }

    @Test
    void InsertOne_returnsFalse_onException() {
        when(repo.save(testProduct)).thenThrow(new RuntimeException("DB error"));

        boolean result = service.InsertOne(testProduct);

        assertFalse(result);
    }

    @Test
    void getByName_returnsProduct_whenExists() {
        when(repo.findByName("Test Product")).thenReturn(testProduct);

        Product result = service.getByName("Test Product");

        assertEquals(testProduct, result);
    }

    @Test
    void getByName_returnsNull_whenNotExists() {
        when(repo.findByName("NonExistent")).thenReturn(null);

        Product result = service.getByName("NonExistent");

        assertNull(result);
    }
}
