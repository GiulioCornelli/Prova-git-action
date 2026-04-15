package com.ttf.controller;

import com.ttf.data.Product;
import com.ttf.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired private ProductService productService;

    @GetMapping("")
    public String getMethodName(Model m) {
        m.addAttribute("listaProdotti", productService.gettAll());
        m.addAttribute("nuovoProdotto", new Product()); // Oggetto vuoto per il form

        return "veiw-product";
    }

    @PostMapping("/add")
    public String postMethodName(@ModelAttribute("nuovoProdotto") Product p) {
        boolean result = productService.InsertOne(p);
        log.info(
                result
                        ? "l'oggetto è stato aggiunto con successo"
                        : "l'oggetto non è stato aggiunto");
        return "redirect:/products";
    }
}
