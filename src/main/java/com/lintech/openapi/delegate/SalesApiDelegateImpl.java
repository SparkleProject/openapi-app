package com.lintech.openapi.delegate;

import com.lintech.openapi.api.SalesApiDelegate;
import com.lintech.openapi.dto.Sale;
import com.lintech.openapi.dto.SalesSummary;
import com.lintech.openapi.service.SalesApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SalesApiDelegateImpl implements SalesApiDelegate {

    @Autowired
    private SalesApiServiceImpl salesApiService;

    @Override
    public ResponseEntity<SalesSummary> placeSales(Sale sale) {
        return ResponseEntity.ok(salesApiService.placeSale(sale));
    }

}
