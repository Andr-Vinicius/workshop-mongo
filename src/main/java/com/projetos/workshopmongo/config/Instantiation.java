package com.projetos.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projetos.workshopmongo.domain.User;
import com.projetos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	UserRepository Userconfig;

	@Override
	public void run(String... args) throws Exception {
		 Userconfig.deleteAll();
		
		 User maria = new User(null, "Maria Brown", "maria@gmail.com");
		 User alex = new User(null, "Alex Green", "alex@gmail.com");
		 User bob = new User(null, "Bob Grey", "bob@gmail.com");
		 
		 Userconfig.saveAll(Arrays.asList(maria, alex, bob));
		 
		 
		 
		
		
	}

}
