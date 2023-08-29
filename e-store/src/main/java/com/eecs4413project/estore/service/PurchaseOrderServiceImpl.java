package com.eecs4413project.estore.service;

import com.eecs4413project.estore.dao.PurchaseOrderRepository;
import com.eecs4413project.estore.entity.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(id);
        return purchaseOrder.orElse(null);
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder) {
        Optional<PurchaseOrder> existingPurchaseOrder = purchaseOrderRepository.findById(id);
        if (existingPurchaseOrder.isPresent()) {
            purchaseOrder.setId(id);
            return purchaseOrderRepository.save(purchaseOrder);
        }
        return null;
    }

    @Override
    public void deletePurchaseOrder(Long id) {
        purchaseOrderRepository.deleteById(id);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersByLastName(String lname) {
        return purchaseOrderRepository.findByLname(lname);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersByFirstName(String fname) {
        return purchaseOrderRepository.findByFname(fname);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersByStatus(String status) {
        return purchaseOrderRepository.findByStatus(status);
    }
}
