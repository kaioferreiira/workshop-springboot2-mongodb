package com.kaioferreira.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import com.kaioferreira.workshopmongo.dto.UserDTO;
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

	//criando metodo para inserir
	public User insert(User obj){
		return repositorioUser.insert(obj);
	}
	//metodo para deletar pegando um id
	public void delete(String id){
		//usa o metodo findById, senão encontrar retorna o throw.
		findById(id);
		repositorioUser.deleteById(id);
	}
	//metodo para realizar o UPDATE
	public User update(User obj) {
		User newObj = findById(obj.getId());
		//metodo para copiar os dados do obj para o newObj
		updateData(newObj, obj);
		return repositorioUser.save(newObj);
	}

	// copiar os dador do obj para o newObj, id não muda
	private void updateData(User newObj, User obj){
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto){
		return new User(objDto.getId(),objDto.getName(), objDto.getEmail());
	}
}
