package com.example.webappSocket.controller;

import com.example.webappSocket.model.Orders;
import org.hibernate.criterion.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController {

    @GetMapping(value = "/user/orders")
    public String Order(){
        return "this is order";
    }

//    @PostMapping(value = "/user/orders")
//    public Orders orderRestaurant(@Valid @RequestBody Orders order){
//
//    }

}
