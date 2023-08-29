package com.eecs4413project.estore.service;

import com.eecs4413project.estore.entity.PurchaseOrderItem;

import java.util.List;

public interface PurchaseOrderItemService {
    List<PurchaseOrderItem> getAllPurchaseOrderItems();

    PurchaseOrderItem createPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);

    void deletePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);
}
