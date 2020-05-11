package com.example.demo.user.controller;

import com.example.demo.user.integration.AddressClient;
import com.example.demo.user.integration.model.Address;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private static List<User> users = new ArrayList<>();

    @NonNull
    private AddressClient addressClient;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<Address> allAddresses = addressClient.getAllAddresses();
        List<User> result = users.stream().map(user -> {
            user.setAddress(allAddresses.get(0));
            return user;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.ok(user);
    }

}
