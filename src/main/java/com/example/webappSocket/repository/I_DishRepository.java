package com.example.webappSocket.repository;

import com.example.webappSocket.model.Dish;
import com.example.webappSocket.model.TypeDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface I_DishRepository extends JpaRepository<Dish, Integer> {
    @Override
    List<Dish> findAll();

    @Override
    <S extends Dish> S save(S entity);
}
