package com.kaioferreira.workshopmongo.resource;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kaioferreira.workshopmongo.domain.User;
import com.kaioferreira.workshopmongo.dto.UserDTO;
import com.kaioferreira.workshopmongo.service.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users") // mapeamento endpoint
public class UserResource {

	// injetando servico do User
	@Autowired
	private UserService userService;

	/*
	 * //definido qual o tipo do metodo
	 * 
	 * @RequestMapping(method = RequestMethod.GET) // ou @GetMapping //public
	 * List<User> findAll(){ //metodo pegando uma lista public
	 * ResponseEntity<List<User>> findAll() { List<User> list = new ArrayList<>();
	 * //instanciando interface User maria = new User("1001", "Maria Brown",
	 * "maria@gmail.com"); User alex = new User("1002", "Alex Green",
	 * "alex@gmail.com");
	 * 
	 * list.addAll(Arrays.asList(maria, alex)); //asList coleta os objetos
	 * 
	 * //return list; return ResponseEntity.ok().body(list); }
	 */

	/*
	 * metodos para encontrar todos com o ReponseEntity
	 * 
	 * @RequestMapping(method = RequestMethod.GET) // ou @GetMapping //public
	 * List<User> findAll(){ //metodo pegando uma lista public
	 * ResponseEntity<List<User>> findAll() { List<User> list =
	 * userService.findAll(); //return list com dados buscados; return
	 * ResponseEntity.ok().body(list); }
	 */

	/// metodos para encontrar todos com o ReponseEntity com o DTO
	@RequestMapping(method = RequestMethod.GET) // ou @GetMapping
	// public List<User> findAll(){ //metodo pegando uma lista
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		// converto os elementos da lista para DTO. Lista orignal,Stream é uma coleção
		// do java8 e
		// o Map pega cada ob x e retorna um new dto e coleta toda lista.

		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		// return list com dados buscados;
		return ResponseEntity.ok().body(listDto);
	}

	/// metodos para encontrar o objeto pelo id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // ou @GetMapping
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User userObj = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(userObj));
	}

	//metodo para inserir um usuario
	@PostMapping //@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity <Void> insert(@RequestBody UserDTO objDto){
		User obj = userService.fromDTO(objDto);
		obj = userService.insert(obj);
		//retorna um cabeçalho com uma url do novo recurso criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//retorna 201, onde se cria um novo recurso,
		return ResponseEntity.created(uri).build();
	}

	/// metodos para encontrar o objeto pelo id e excluir
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // ou @DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userService.delete(id);
		return ResponseEntity.noContent().build(); //no contente é uma resposta com  204, que é um metodo sem resposta.
	}




}