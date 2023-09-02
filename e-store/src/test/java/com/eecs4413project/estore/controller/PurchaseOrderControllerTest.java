package com.eecs4413project.estore.controller;

import com.eecs4413project.estore.entity.Address;
import com.eecs4413project.estore.entity.PurchaseOrder;
import com.eecs4413project.estore.service.PurchaseOrderService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PurchaseOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PurchaseOrderService purchaseOrderService;

    @Test
    public void testGetAllPurchaseOrders() throws Exception {
        Address address1 = new Address("123 Yonge St", "ON", "Canada", "K1E 6T5", "647-123-4567");
        Address address2 = new Address("445 Avenue rd", "ON", "Canada", "M1C 6K5", "416-123-8569");

        PurchaseOrder purchaseOrder1 = new PurchaseOrder("White", "John", "PROCESSED", address1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder("Black", "Peter", "DENIED", address2);
        List<PurchaseOrder> purchaseOrders = Arrays.asList(purchaseOrder1, purchaseOrder2);

        when(purchaseOrderService.getAllPurchaseOrders()).thenReturn(purchaseOrders);

        mockMvc.perform(get("/api/purchase-orders"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(purchaseOrders.size()));
    }

    @Test
    public void testGetPurchaseOrderById() throws Exception {
        Address address1 = new Address("123 Yonge St", "ON", "Canada", "K1E 6T5", "647-123-4567");

        Long purchaseOrderId = 1L;
        PurchaseOrder purchaseOrder = new PurchaseOrder("White", "John", "PROCESSED", address1);
        when(purchaseOrderService.getPurchaseOrderById(purchaseOrderId)).thenReturn(purchaseOrder);

        mockMvc.perform(get("/api/purchase-orders/{id}", purchaseOrderId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.lname").value(purchaseOrder.getLname()))
                .andExpect(jsonPath("$.fname").value(purchaseOrder.getFname()))
                .andExpect(jsonPath("$.status").value(purchaseOrder.getStatus()));
    }

    @Test
    public void testGetPurchaseOrdersByLastName() throws Exception {
        Address address1 = new Address("123 Yonge St", "ON", "Canada", "K1E 6T5", "647-123-4567");
        Address address2 = new Address("445 Avenue rd", "ON", "Canada", "M1C 6K5", "416-123-8569");

        String lastName = "White";
        List<PurchaseOrder> purchaseOrders = Arrays.asList(
                new PurchaseOrder("White", "John", "PROCESSED", address1),
                new PurchaseOrder("White", "Jane", "DENIED", address2)
        );
        when(purchaseOrderService.getPurchaseOrdersByLastName(lastName)).thenReturn(purchaseOrders);

        mockMvc.perform(get("/api/purchase-orders/by-lastname/{lname}", lastName))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(purchaseOrders.size()));
    }

    @Test
    public void testGetPurchaseOrdersByFirstName() throws Exception {
        Address address1 = new Address("123 Yonge St", "ON", "Canada", "K1E 6T5", "647-123-4567");
        Address address2 = new Address("445 Avenue rd", "ON", "Canada", "M1C 6K5", "416-123-8569");

        String firstName = "John";
        List<PurchaseOrder> purchaseOrders = Arrays.asList(
                new PurchaseOrder("White", "John", "PROCESSED", address1),
                new PurchaseOrder("Doe", "John", "ORDERED", address2)
        );
        when(purchaseOrderService.getPurchaseOrdersByFirstName(firstName)).thenReturn(purchaseOrders);

        mockMvc.perform(get("/api/purchase-orders/by-firstname/{fname}", firstName))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(purchaseOrders.size()));
    }

    @Test
    public void testGetPurchaseOrdersByStatus() throws Exception {
        Address address1 = new Address("123 Yonge St", "ON", "Canada", "K1E 6T5", "647-123-4567");
        Address address2 = new Address("445 Avenue rd", "ON", "Canada", "M1C 6K5", "416-123-8569");

        String status = "PROCESSED";
        List<PurchaseOrder> purchaseOrders = Arrays.asList(
                new PurchaseOrder("White", "John", "PROCESSED", address1),
                new PurchaseOrder("Black", "Jane", "PROCESSED", address2)
        );
        when(purchaseOrderService.getPurchaseOrdersByStatus(status)).thenReturn(purchaseOrders);

        mockMvc.perform(get("/api/purchase-orders/by-status/{status}", status))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(purchaseOrders.size()));
    }
}
