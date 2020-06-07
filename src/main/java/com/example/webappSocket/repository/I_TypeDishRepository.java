package com.example.webappSocket.repository;

import com.example.webappSocket.model.Dish;
import com.example.webappSocket.model.TypeDish;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface I_TypeDishRepository extends JpaRepository<TypeDish, Integer> {
    @Query("from TypeDish where name = ?1")
    List<TypeDish> getTypeDishByName(String name);

    @Override
    List<TypeDish> findAll();
//override
    @Override
    <S extends TypeDish> S save(S entity);
}
