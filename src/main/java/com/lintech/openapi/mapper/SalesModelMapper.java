package com.lintech.openapi.mapper;

import com.lintech.openapi.dao.ProductRepository;
import com.lintech.openapi.dto.Sale;
import com.lintech.openapi.dto.SaleItem;
import com.lintech.openapi.exception.ProductNotFoundException;
import com.lintech.openapi.model.ProductEntity;
import com.lintech.openapi.model.SaleEntity;
import com.lintech.openapi.model.SaleItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;


@Service
public class SalesModelMapper {

    @Autowired
    private ProductRepository productRepository;

    public SaleEntity mapToEntity(Sale sale){
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setDiscount(sale.getDiscount());
        saleEntity.setTimeStamp(OffsetDateTime.now());
        for (SaleItem lineItem : sale.getLineItems()) {
            SaleItemEntity saleItem = new SaleItemEntity();
            saleItem.setSale(saleEntity);
            saleItem.setQuantity(lineItem.getQuantity().intValue());
            ProductEntity product = productRepository.findById(lineItem.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException("Product not found:"+ lineItem.getProductId()));
            saleItem.setProduct(product);
            saleEntity.getSaleItems().add(saleItem);
        }
        return saleEntity;
    }
}
