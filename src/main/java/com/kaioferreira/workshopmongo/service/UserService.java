package com.kaioferreira.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaioferreira.workshopmongo.domain.User;
import com.kaioferreira.workshopmongo.exception.ObjectNotFoundException;
import com.kaioferreira.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repositorioUser;

	// Serviço para Listar todos os Usuários.
	public List<User> findAll() {
		return repositorioUser.findAll();
	}

	// Serviço para encontar usuário por Id
	public User findById(String id) {
		//cria um objeto user do tipo optional
		Optional<User> obj = repositorioUser.findById(id);
		// lançar aqui a exception personalizada
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
