package com.projetos.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projetos.workshopmongo.domain.User;
import com.projetos.workshopmongo.dto.UserDTO;
import com.projetos.workshopmongo.repository.UserRepository;
import com.projetos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		// Estudar sobre o Optional e sobre o orElseThrow
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id); // Tratar a exceção
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		
		return repo.save(newObj);
		
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	
	public User updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
		return newObj;
	}
	

}
