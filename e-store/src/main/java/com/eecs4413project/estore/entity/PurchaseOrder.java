package com.eecs4413project.estore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "po")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lname")
    private String lname;

    @Column(name = "fname")
    private String fname;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public PurchaseOrder() {

    }

    public PurchaseOrder(String lname, String fname, String status, Address address) {
        this.lname = lname;
        this.fname = fname;
        this.status = status;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", lname='" + lname + '\'' +
                ", fname='" + fname + '\'' +
                ", status='" + status + '\'' +
                ", address=" + address +
                '}';
    }
}
