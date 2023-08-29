package com.eecs4413project.estore.dao;

import com.eecs4413project.estore.entity.PurchaseOrderItem;
import com.eecs4413project.estore.entity.PurchaseOrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem, PurchaseOrderItemId> {
    // Add custom query methods here if needed
}
