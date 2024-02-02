package com.lintech.openapi.service;


import com.lintech.openapi.dao.ProductRepository;
import com.lintech.openapi.dto.Product;
import com.lintech.openapi.model.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsApiServiceImpl implements ProductsApiService{


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAll();
        Optional.of(entities)
                .ifPresent(list -> list.forEach(p -> products.add(modelMapper.map(p, Product.class))));
       return products;
    }

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = productRepository.save(modelMapper.map(product, ProductEntity.class));
        return (modelMapper.map(productEntity, Product.class));
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .map(p -> modelMapper.map(p, Product.class))
                .orElse(null);
    }

}
