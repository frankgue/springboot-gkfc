package com.gkfcsolution.demorest.service;

import com.gkfcsolution.demorest.exception.ProductNotfoundException;
import com.gkfcsolution.demorest.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private static Map<String, Product> productRepo = new HashMap<>();

    static {

        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);

    }

    @Override
    public void createProduct(Product product) {
        productRepo.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product, String id) {
        if (!productRepo.containsKey(id)) throw new ProductNotfoundException();
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }

    @Override
    public Collection<Product> getPoducts() {
        return productRepo.values();
    }

    @Override
    public void deleteProduct(String id) {
        productRepo.remove(id);
    }
}
