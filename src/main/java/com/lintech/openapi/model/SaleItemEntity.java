package com.lintech.openapi.model;

import javax.persistence.*;

@Entity
@Table(name = "Sale_Item")
public class SaleItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="sale_id", referencedColumnName = "id", nullable=false)
    private SaleEntity sale;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="product_id",  referencedColumnName = "id",  nullable=false)
    private ProductEntity product;

    @Column(name = "quantity")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SaleEntity getSale() {
        return sale;
    }

    public void setSale(SaleEntity sale) {
        this.sale = sale;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
