package com.projetos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projetos.workshopmongo.domain.Post;
import com.projetos.workshopmongo.domain.User;
import com.projetos.workshopmongo.dto.AuthorDTO;
import com.projetos.workshopmongo.repository.PostRepository;
import com.projetos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	UserRepository userConfig;
	
	@Autowired
	PostRepository postConfig;

	@Override
	public void run(String... args) throws Exception {
		
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		 userConfig.deleteAll();
		 postConfig.deleteAll();
		
		 User maria = new User(null, "Maria Brown", "maria@gmail.com");
		 User alex = new User(null, "Alex Green", "alex@gmail.com");
		 User bob = new User(null, "Bob Grey", "bob@gmail.com");
		 userConfig.saveAll(Arrays.asList(maria, alex, bob));
		 
		 Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Irei viajar para SP", new AuthorDTO(maria));
		 Post post2 = new Post(null, sdf.parse("25/04/2020"), "Aprendendo Spring", "Desenvolvendo um novo projeto", new AuthorDTO(alex));
		 
		 postConfig.saveAll(Arrays.asList(post1, post2));
		 
		 maria.getPosts().addAll(Arrays.asList(post1, post2));
		 userConfig.save(maria);
		 
		 
		
		
	}

}
