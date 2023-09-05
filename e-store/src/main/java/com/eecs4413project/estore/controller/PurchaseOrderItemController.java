package com.eecs4413project.estore.controller;

import com.eecs4413project.estore.entity.PurchaseOrderItem;
import com.eecs4413project.estore.service.PurchaseOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemController {
    @Autowired
    private PurchaseOrderItemService purchaseOrderItemService;

    @GetMapping
    public ResponseEntity<List<PurchaseOrderItem>> getAllPurchaseOrderItems() {
        List<PurchaseOrderItem> purchaseOrderItems = purchaseOrderItemService.getAllPurchaseOrderItems();
        return ResponseEntity.ok(purchaseOrderItems);
    }

    @PostMapping
    public ResponseEntity<PurchaseOrderItem> createPurchaseOrderItem(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        PurchaseOrderItem createdPurchaseOrderItem = purchaseOrderItemService.createPurchaseOrderItem(purchaseOrderItem);
        return ResponseEntity.ok(createdPurchaseOrderItem);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePurchaseOrderItem(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        purchaseOrderItemService.deletePurchaseOrderItem(purchaseOrderItem);
        return ResponseEntity.noContent().build();
    }
}
