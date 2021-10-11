package com.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
	
}
