package com.projetos.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.workshopmongo.domain.User;

@RestController // Recurso Rest
@RequestMapping(value = "/users") // Caminho da endpoint
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User user1 = new User("1", "Vinicius", "teste@gmail.com");
		User user2 = new User("2", "Maria", "teste2@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(user1, user2));
		return ResponseEntity.ok().body(list);
	}
}
