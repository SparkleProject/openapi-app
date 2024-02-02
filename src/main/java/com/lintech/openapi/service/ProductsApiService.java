package com.lintech.openapi.service;

import com.lintech.openapi.dto.Product;

import java.util.List;

public interface ProductsApiService {

    public List<Product> getProducts();

    public Product getProductById(Long id);

    public Product createProduct(Product product);
}
