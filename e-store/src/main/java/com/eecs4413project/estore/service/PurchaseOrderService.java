package com.eecs4413project.estore.service;

import com.eecs4413project.estore.entity.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {
    List<PurchaseOrder> getAllPurchaseOrders();

    PurchaseOrder getPurchaseOrderById(Long id);

    PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder);

    PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder);

    void deletePurchaseOrder(Long id);

    List<PurchaseOrder> getPurchaseOrdersByLastName(String lname);

    List<PurchaseOrder> getPurchaseOrdersByFirstName(String fname);

    List<PurchaseOrder> getPurchaseOrdersByStatus(String status);
}
