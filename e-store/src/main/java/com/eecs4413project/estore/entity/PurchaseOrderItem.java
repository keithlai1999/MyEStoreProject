package com.eecs4413project.estore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "poitem")
@IdClass(PurchaseOrderItemId.class)
public class PurchaseOrderItem {
    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    private PurchaseOrder purchaseOrder;

    @Id
    @ManyToOne
    @JoinColumn(name = "bid")
    private Item item;

    @Column(name = "price")
    private int price;

    public PurchaseOrderItem() {

    }

    public PurchaseOrderItem(PurchaseOrder purchaseOrder, Item item, int price) {
        this.purchaseOrder = purchaseOrder;
        this.item = item;
        this.price = price;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PurchaseOrderItem{" +
                "purchaseOrder=" + purchaseOrder +
                ", item=" + item +
                ", price=" + price +
                '}';
    }
}
