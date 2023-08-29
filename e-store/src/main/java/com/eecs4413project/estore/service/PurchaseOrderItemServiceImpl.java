package com.eecs4413project.estore.service;

import com.eecs4413project.estore.dao.PurchaseOrderItemRepository;
import com.eecs4413project.estore.entity.PurchaseOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService{
    @Autowired
    private PurchaseOrderItemRepository purchaseOrderItemRepository;

    @Override
    public List<PurchaseOrderItem> getAllPurchaseOrderItems() {
        return purchaseOrderItemRepository.findAll();
    }

    @Override
    public PurchaseOrderItem createPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemRepository.save(purchaseOrderItem);
    }

    @Override
    public void deletePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
        purchaseOrderItemRepository.delete(purchaseOrderItem);
    }
}
