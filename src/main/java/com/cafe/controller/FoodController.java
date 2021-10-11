package com.cafe.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.model.Food;
import com.cafe.service.FoodService;

@RestController
@RequestMapping(value= "/food")

public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping
	public List<Food> listar() {
		return foodService.listar();
	}
	
	@GetMapping("/{foodId}")
	public ResponseEntity<Optional<Food>> buscar(@PathVariable Long foodId){
		Optional<Food> retorno = foodService.buscarId(foodId);
		if(retorno == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> adicionar(@Valid @RequestBody Food food){
		try {
			return new ResponseEntity<>(foodService.salvar(food), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao registrar a comida", HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@PutMapping("/{foodId}")
	public ResponseEntity<String> alterar(@Valid @RequestBody Food food, @PathVariable Long foodId ){
		try {
			return new ResponseEntity<>(foodService.alterar(food, foodId), HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>("Erro ao alterar a comida",HttpStatus.NOT_MODIFIED);
		}
	}
	
	@DeleteMapping("/{foodId}")
	public ResponseEntity<String> excluir(@PathVariable Long foodId){
		try {
			return new ResponseEntity<>(foodService.excluir(foodId), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>("Erro ao deletar comida", HttpStatus.NOT_MODIFIED);
		}
	}
	
}
