package com.eecs4413project.estore.controller;

import com.eecs4413project.estore.entity.PurchaseOrder;
import com.eecs4413project.estore.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        List<PurchaseOrder> purchaseOrders = purchaseOrderService.getAllPurchaseOrders();
        return ResponseEntity.ok(purchaseOrders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable Long id) {
        PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrderById(id);
        if (purchaseOrder != null) {
            return ResponseEntity.ok(purchaseOrder);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder createdPurchaseOrder = purchaseOrderService.createPurchaseOrder(purchaseOrder);
        return ResponseEntity.ok(createdPurchaseOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@PathVariable Long id, @RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder updatedPurchaseOrder = purchaseOrderService.updatePurchaseOrder(id, purchaseOrder);
        if (updatedPurchaseOrder != null) {
            return ResponseEntity.ok(updatedPurchaseOrder);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable Long id) {
        purchaseOrderService.deletePurchaseOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-lastname/{lname}")
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrdersByLastName(@PathVariable String lname) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderService.getPurchaseOrdersByLastName(lname);
        return ResponseEntity.ok(purchaseOrders);
    }

    @GetMapping("/by-firstname/{fname}")
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrdersByFirstName(@PathVariable String fname) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderService.getPurchaseOrdersByFirstName(fname);
        return ResponseEntity.ok(purchaseOrders);
    }

    @GetMapping("/by-status/{status}")
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrdersByStatus(@PathVariable String status) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderService.getPurchaseOrdersByStatus(status);
        return ResponseEntity.ok(purchaseOrders);
    }
}
