package com.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.model.User;
import com.cafe.repository.UserRepository;

@RestController
@RequestMapping(value="/")
public class UserController {
	
	
	@Autowired
	
	UserRepository userrepository;
	
	@GetMapping("/user")
		public List<User> userList(){
		return userrepository.findAll();
	}
	
	@GetMapping("/user/{id}")
		public User searchUser(@PathVariable(value="id") long id) {
		return userrepository.findById(id);
		
	}
	
	@PostMapping("/user")
		public User saveUser(@RequestBody User user){
		return userrepository.save(user);
	}
	
	@DeleteMapping("/user/{id}")
		public void deleteUser(@PathVariable(value="id") long id) {
		userrepository.deleteById(id);
	}
	
	@PutMapping("/user")
		public User updateUser(@RequestBody User user) {
		return userrepository.save(user);
	}
	
	
}



