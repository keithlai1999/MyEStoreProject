package com.eecs4413project.estore.dao;

import com.eecs4413project.estore.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    // Add custom query methods here if needed
    List<PurchaseOrder> findByLname(String lname);

    List<PurchaseOrder> findByFname(String fname);

    List<PurchaseOrder> findByStatus(String status);
}
