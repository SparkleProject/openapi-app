package com.lintech.openapi.service;

import com.lintech.openapi.dto.Sale;
import com.lintech.openapi.dto.SalesSummary;

public interface SalesApiService {

    public SalesSummary placeSale(Sale sale);
}
