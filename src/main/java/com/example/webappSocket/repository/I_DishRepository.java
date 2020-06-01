package com.example.webappSocket.repository;

import com.example.webappSocket.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface I_DishRepository extends JpaRepository<Dish,Integer> {

    @Query("from Dish")
    List<Dish> getAllDish();


}
