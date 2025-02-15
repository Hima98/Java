package com.springbootacademy.batch7.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name ="customer")
@TypeDefs({@TypeDef(name="json",typeClass = JsonType.class)})
public class Customer {
    @Id
    @Column(name="customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name="customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name="customer_address",length = 200)
    private String customerAddress;

    @Type(type="json")
    @Column(name="contact_numbers" ,columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name="customer_salary")
    private double customerSalary;

    @Column(name="nic")
    private String nic;

    @Column(name="active_state",columnDefinition = "TINYINT default 1")
    private boolean active;

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public String getNic() {
        return nic;
    }

    public boolean isActive() {
        return active;
    }

    public Customer(int customerId, String customerName, String customerAddress, ArrayList contactNumber, double customerSalary, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumber = contactNumber;
        this.customerSalary = customerSalary;
        this.nic = nic;
        this.active = active;


    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumber=" + contactNumber +
                ", customerSalary=" + customerSalary +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
