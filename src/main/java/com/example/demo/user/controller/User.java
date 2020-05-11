package com.example.demo.user.controller;

import com.example.demo.user.integration.model.Address;
import lombok.Data;

@Data
public class User {
    private String firstname;
    private String lastname;
    private Address address;


    public void setAddress(Address address) {
        this.address = address;
    }
}
