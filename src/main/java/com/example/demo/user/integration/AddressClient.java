package com.example.demo.user.integration;

import com.example.demo.user.integration.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "demo-address")
public interface AddressClient {
    @GetMapping("/address")
    List<Address> getAllAddresses();
}
