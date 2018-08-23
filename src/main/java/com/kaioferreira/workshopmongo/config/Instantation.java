package com.kaioferreira.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.kaioferreira.workshopmongo.dto.Post;
import com.kaioferreira.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kaioferreira.workshopmongo.domain.User;
import com.kaioferreira.workshopmongo.repository.UserRepository;

@Configuration
public class Instantation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository  posRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		//INICIA O PROJETO DELETANDO TODOS O USUÁRIOS
		userRepository.deleteAll();

		//inicia os posts no banco como vazio
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		Post newPost = new Post(null, sdf.parse("21/03/2018"),"Partiu viagem", "Viajando para minas!!!", maria );
		Post newPost2 = new Post(null, sdf.parse("05/08/2018"),"Partiu South", "Tafafeeeeelllllll!!" , maria);


		//salvando os usuários
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		//salvando os posts
		posRepository.saveAll(Arrays.asList(newPost, newPost2));
	}
	
	

}
