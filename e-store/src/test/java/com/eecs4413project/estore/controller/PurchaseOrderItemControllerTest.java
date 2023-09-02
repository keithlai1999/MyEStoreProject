package com.eecs4413project.estore.controller;

import com.eecs4413project.estore.entity.Address;
import com.eecs4413project.estore.entity.Item;
import com.eecs4413project.estore.entity.PurchaseOrder;
import com.eecs4413project.estore.entity.PurchaseOrderItem;
import com.eecs4413project.estore.service.PurchaseOrderItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PurchaseOrderItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PurchaseOrderItemService purchaseOrderItemService;

    @Test
    public void testGetAllPurchaseOrderItems() throws Exception {
        Address address1 = new Address("123 Yonge St", "ON", "Canada", "K1E 6T5", "647-123-4567");
        Address address2 = new Address("445 Avenue rd", "ON", "Canada", "M1C 6K5", "416-123-8569");

        Item item1 = new Item("b001", "Little Prince", "a book for all ages", "book", "Penguin", 20, 100);
        Item item2 = new Item("c001", "iPad", "a device for personal use", "computer", "Apple", 500, 100);

        PurchaseOrder purchaseOrder1 = new PurchaseOrder("John", "White", "PROCESSED", address1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder("Peter", "Black", "DENIED", address2);

        PurchaseOrderItem poItem1 = new PurchaseOrderItem(purchaseOrder1, item1, 20);
        PurchaseOrderItem poItem2 = new PurchaseOrderItem(purchaseOrder2, item2, 500);

        List<PurchaseOrderItem> items = Arrays.asList(poItem1, poItem2);

        when(purchaseOrderItemService.getAllPurchaseOrderItems()).thenReturn(items);

        mockMvc.perform(get("/api/purchase-order-items"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(items.size()));
    }

    @Test
    public void testCreatePurchaseOrderItem() throws Exception {
        Address address = new Address("789 Keele St.", "ON", "Canada", "K3C 9T5", "416-123-9568");

        Item newItem = new Item("d001", "Laptop", "a device for personal use", "computer", "Apple", 1500, 100);

        PurchaseOrder newPurchaseOrder = new PurchaseOrder("Andy", "Green", "ORDERED", address);

        PurchaseOrderItem newPoItem = new PurchaseOrderItem(newPurchaseOrder, newItem, 1500);

        when(purchaseOrderItemService.createPurchaseOrderItem(any(PurchaseOrderItem.class))).thenReturn(newPoItem);

        mockMvc.perform(post("/api/purchase-order-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newPoItem)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.purchaseOrder.fname").value(newPoItem.getPurchaseOrder().getFname()))
                .andExpect(jsonPath("$.item.name").value(newPoItem.getItem().getName()))
                .andExpect(jsonPath("$.price").value(newPoItem.getPrice()));
    }

}
