package com.eecs4413project.estore.entity;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseOrderItemId implements Serializable {
    private Long purchaseOrder;
    private String item;

    public PurchaseOrderItemId() {

    }

    public PurchaseOrderItemId(Long purchaseOrder, String item) {
        this.purchaseOrder = purchaseOrder;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseOrderItemId that)) return false;
        return Objects.equals(purchaseOrder, that.purchaseOrder) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseOrder, item);
    }
}
