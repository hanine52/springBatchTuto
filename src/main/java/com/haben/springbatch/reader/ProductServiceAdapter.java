package com.haben.springbatch.reader;

import com.haben.springbatch.model.Product;
import com.haben.springbatch.service.ProductService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductServiceAdapter implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }

//    @Autowired
//    private ProductService service;
//
//    private ArrayList<Product> products;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        this.products = service.getProducts();
//    }
//
//    public Product nextProduct(){
//        if ( products.size() >0) { return products.remove(0); }
//        return null;
//    }
//
//    public ProductService getService() {
//        return service;
//    }
//
//    public void setService(ProductService service) {
//        this.service = service;
//    }
//
//    public ArrayList<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(ArrayList<Product> products) {
//        this.products = products;
//    }
}
