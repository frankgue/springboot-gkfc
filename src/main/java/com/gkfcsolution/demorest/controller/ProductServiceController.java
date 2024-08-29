package com.gkfcsolution.demorest.controller;

import com.gkfcsolution.demorest.DemoRestApplication;
import com.gkfcsolution.demorest.exception.ProductNotfoundException;
import com.gkfcsolution.demorest.model.Product;
import com.gkfcsolution.demorest.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ProductServiceController {


    private static final Logger LOG =
            Logger.getLogger(DemoRestApplication.class.getName());

    @Autowired
    ProductServiceImpl productService;

    @RequestMapping("/products")
    public ResponseEntity<Object> getAllProducts(){

        LOG.log(Level.INFO, "Index API is calling to get all product");
        return new ResponseEntity<>(productService.getPoducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable("id") String id) {
        productService.updateProduct(product, id);
        return new ResponseEntity<>("Product is update successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
        LOG.log(Level.INFO, "Index API is calling");
        productService.deleteProduct(id);
        return  new ResponseEntity<>("Product Delete successfully", HttpStatus.OK);
    }

}
