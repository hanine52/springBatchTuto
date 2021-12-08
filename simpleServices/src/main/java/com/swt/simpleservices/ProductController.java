package com.swt.simpleservices;

import com.swt.simpleservices.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @GetMapping("/products")
    public List<Product> getProdcts(){
        ArrayList<Product> products = new ArrayList<>();
        // public Product(Integer productId, String prodName, BigDecimal price, Integer unit, String productDesc)
        products.add(new Product(1,"Apple", BigDecimal.valueOf(300.00),10,"Apple Cell from service"));
        products.add(new Product(2,"Dell", BigDecimal.valueOf(700.00),10,"Dell computerfrom service"));
        return products;
    }
}
