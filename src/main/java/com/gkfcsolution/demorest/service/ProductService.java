package com.gkfcsolution.demorest.service;

import com.gkfcsolution.demorest.model.Product;

import java.util.Collection;

public interface ProductService {
    void  createProduct(Product product);
    void updateProduct(Product product, String id);
    Collection<Product> getPoducts();
    void deleteProduct(String id);
}
