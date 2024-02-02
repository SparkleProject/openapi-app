package com.lintech.openapi.delegate;

import com.lintech.openapi.api.ProductsApiDelegate;
import com.lintech.openapi.dto.Product;
import com.lintech.openapi.service.ProductsApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsApiDelegateImpl implements ProductsApiDelegate{

    @Autowired
    private ProductsApiServiceImpl productsApiService;

    @Override
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productsApiService.getProducts());
    }

    @Override
    public ResponseEntity<Product> createProduct(Product product) {
        return ResponseEntity.ok(productsApiService.createProduct(product));
    }
}
