package com.lintech.openapi.service;

import com.lintech.openapi.dao.SaleRepository;
import com.lintech.openapi.exception.ProductNotFoundException;
import com.lintech.openapi.dto.Product;
import com.lintech.openapi.dto.Sale;
import com.lintech.openapi.dto.SaleItem;
import com.lintech.openapi.dto.SalesSummary;
import com.lintech.openapi.mapper.SalesModelMapper;
import com.lintech.openapi.model.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SalesApiServiceImpl {

    @Autowired
    private ProductsApiServiceImpl productsApiService;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SalesModelMapper salesModelMapper;

    private final Map<Long, Sale> salesDb = new ConcurrentHashMap<>();

    public SalesSummary placeSale(Sale sale){
        SaleEntity saleEntity = salesModelMapper.mapToEntity(sale);
        saleRepository.save(saleEntity);
        return mapSaleSummary(sale);
    }

    private SalesSummary mapSaleSummary(Sale sale){
        SalesSummary summary = new SalesSummary();
        long totalItems = sale.getLineItems().stream().mapToLong(SaleItem::getQuantity).sum();

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (SaleItem lineItem : sale.getLineItems()) {
            Product product = Optional.ofNullable(productsApiService.getProductById(lineItem.getProductId()))
                    .orElseThrow(() -> new ProductNotFoundException("Product not found:"+ lineItem.getProductId()));

            totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(lineItem.getQuantity())));
        }

        if(sale.getDiscount().compareTo(BigDecimal.ZERO) >= 0
                && sale.getDiscount().compareTo(BigDecimal.valueOf(100)) <=0){
            totalPrice = totalPrice.multiply(BigDecimal.valueOf(100).subtract(sale.getDiscount())).divide(BigDecimal.valueOf(100));
            sale.getLineItems().forEach(item -> item.setDiscount(sale.getDiscount().toString()+"%"));
        }


        summary.setTotalItems(totalItems);
        summary.setTotalPrice(totalPrice);
        summary.setSale(sale);

        return summary;
    }



    private long getNextId(){
        return ThreadLocalRandom.current().nextLong(4,100);
    }
}
