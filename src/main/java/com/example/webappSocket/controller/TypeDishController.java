package com.example.webappSocket.controller;

import com.example.webappSocket.model.TypeDish;
import com.example.webappSocket.repository.I_TypeDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TypeDishController {

    @Autowired
    I_TypeDishRepository typeDishRepository;

    @GetMapping(value = "/pub/get-all-typedish")
    public List<TypeDish> getAllDish(){
        List<TypeDish> allTypeDish = new ArrayList<>();
        allTypeDish = typeDishRepository.findAll();
        return allTypeDish;
    }

    @PostMapping(value = "/pub/add-typedish")
    public TypeDish addTypeDish(@Valid @RequestBody TypeDish typeDish) {
        typeDishRepository.save(typeDish);
        return typeDish;
    }

}
