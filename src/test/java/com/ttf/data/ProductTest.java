package com.ttf.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void constructor_createsProductWithAllFields() {
        Product product = new Product(1L, "Test", "Description", 10.5f);

        assertEquals(1L, product.getProductid());
        assertEquals("Test", product.getName());
        assertEquals("Description", product.getDescription());
        assertEquals(10.5f, product.getPrice());
    }

    @Test
    void defaultConstructor_createsEmptyProduct() {
        Product product = new Product();

        assertEquals(0L, product.getProductid());
        assertNull(product.getName());
        assertNull(product.getDescription());
        assertEquals(0f, product.getPrice());
    }

    @Test
    void setters_updateFields() {
        Product product = new Product();
        product.setProductid(2L);
        product.setName("Updated");
        product.setDescription("New desc");
        product.setPrice(25.99f);

        assertEquals(2L, product.getProductid());
        assertEquals("Updated", product.getName());
        assertEquals("New desc", product.getDescription());
        assertEquals(25.99f, product.getPrice());
    }
}
