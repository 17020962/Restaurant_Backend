package com.example.webappSocket.controller;

import com.example.webappSocket.model.Dish;
import com.example.webappSocket.repository.I_DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DishController {

    @Autowired
    I_DishRepository dishRepository;

    @GetMapping(value = "/pub/get-all-dish")
    public List<Dish> getAllDish() {
        List<Dish> allDish = new ArrayList<>();
        allDish = dishRepository.getAllDish();
        return allDish;
    }

    @PostMapping(value = "/admin/add-dish")
    public Dish addDish(@Valid @RequestBody Dish dish) {
        dishRepository.save(dish);
        return dish;
    }

}
