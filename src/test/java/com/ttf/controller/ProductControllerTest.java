package com.ttf.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ttf.data.Product;
import com.ttf.service.ProductService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock private ProductService productService;

    @Mock private Model model;

    @InjectMocks private ProductController controller;

    private Product testProduct;

    @BeforeEach
    void setUp() {
        testProduct = new Product(1L, "Laptop", "Gaming laptop", 1299.99f);
    }

    @Test
    void getMethodName_addsProductsToModel() {
        List<Product> products = Arrays.asList(testProduct);
        when(productService.gettAll()).thenReturn(products);

        String viewName = controller.getMethodName(model);

        assertEquals("veiw-product", viewName);
        verify(model).addAttribute("listaProdotti", products);
        verify(model).addAttribute(eq("nuovoProdotto"), any(Product.class));
    }

    @Test
    void postMethodName_redirectsAfterInsert() {
        when(productService.InsertOne(testProduct)).thenReturn(true);

        String viewName = controller.postMethodName(testProduct);

        assertEquals("redirect:/products", viewName);
        verify(productService).InsertOne(testProduct);
    }

    @Test
    void postMethodName_redirectsEvenOnFailure() {
        when(productService.InsertOne(testProduct)).thenReturn(false);

        String viewName = controller.postMethodName(testProduct);

        assertEquals("redirect:/products", viewName);
        verify(productService).InsertOne(testProduct);
    }
}
