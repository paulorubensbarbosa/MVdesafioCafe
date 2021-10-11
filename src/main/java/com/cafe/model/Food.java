package com.cafe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="FOOD")
public class Food implements Serializable {
	
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long idFood;
	
	@Column(nullable = false, length = 30, unique = true )
	private String food;

	public long getIdFood() {
		return idFood;
	}

	public void setIdFood(long idFood) {
		this.idFood = idFood;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public Food(long idFood, String food) {
		super();
		this.idFood = idFood;
		this.food = food;
	}
	
	public Food() {
		super();
	}
	
	
			
}
