package com.cafe.service;

import java.util.List;
import java.util.Optional;


import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.model.Food;
import com.cafe.repository.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	FoodRepository foodRepository;
	
	public String salvar(Food food) {
		foodRepository.save(food);
		
		return "Comida registrada com sucesso";
	}
	
	public List<Food> listar(){
		return foodRepository.findAll();
	}
	
	public Optional<Food> buscarId(Long id){
		Optional<Food> food = foodRepository.findById(id);
		if(food.isPresent()) {
			return food;
		}else {
			return null;
		}
	}
	
	public String alterar(Food food, Long id) {
		Optional<Food> food1 = foodRepository.findById(id);
		if (food1.isPresent()) {
			food.setIdFood(id);
			foodRepository.save(food);
			return "Fila alterada com sucesso!"; 
		}
		return "Fila não encontrada";
	}
	
	@Transactional
	public String excluir(Long id) {
		Optional<Food> user = foodRepository.findById(id);
		if(user.isPresent()) {
			foodRepository.deleteById(id);
			return "Comida excluída com sucesso";
		}
		return "Comida não encontrada";
	}
	

	
}
