package com.cafe.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="USER")
public class User implements Serializable {
	
	public User() {
		super();
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JoinColumn
	private long id;
	
	@Length(min = 3, max = 100, message = "O nome deve possuir no mínimo 3 caracteres")
	private String nome;
	
	@Column(unique = true)
	@Length(min = 11, max = 11, message = "Digite um CPF válido (apenas números)")
	private String cpf;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Food> food;
		
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Food> getFood(){
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	
	public User(long id, String nome, String cpf, List<Food> food) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.food = food;
	}
	
		
}
