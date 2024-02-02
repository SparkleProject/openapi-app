package com.lintech.openapi.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Sale")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "timeStamp")
    private OffsetDateTime timeStamp;

    @OneToMany(mappedBy="sale", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SaleItemEntity> saleItems = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public OffsetDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(OffsetDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<SaleItemEntity> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItemEntity> saleItems) {
        this.saleItems = saleItems;
    }
}
