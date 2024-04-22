package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping("/api/Product")
    public ResponseEntity<Product> postMethod(@RequestBody Product s) {
        if (service.post(s)) {
            return new ResponseEntity<Product>(s, HttpStatus.CREATED);
        } else {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/product")
    public ResponseEntity<List<Product>> dndcjk() {
        List<Product> page = service.getAll();
        if (!page.isEmpty()) {
            return new ResponseEntity<List<Product>>(page, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/api/product/category/{productCategory}")
    public ResponseEntity<List<Product>> getbyid(@PathVariable String productCategory) {
        List<Product> p = service.getProduct(productCategory);
        if (!p.isEmpty()) {
            return new ResponseEntity<List<Product>>(p, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("/api/product/category/priceCategory/{priceCategory}")
    public ResponseEntity<List<Product>> getbdyid(@PathVariable String priceCategory) {
        List<Product> p = service.getProductbyprice(priceCategory);
        if (!p.isEmpty()) {
            return new ResponseEntity<List<Product>>(p, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

}
