package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    @SuppressWarnings("null")
    public boolean post(Product c) {
        try {

            repo.save(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Product> getAll() {
        return repo.findAll();

    }

    public List<Product> getProduct(String age) {
        return repo.findByProductCategory(age);

    }
    public List<Product> getProductbyprice(String age) {
        return repo.findByPriceCategory(age);

    }

}
