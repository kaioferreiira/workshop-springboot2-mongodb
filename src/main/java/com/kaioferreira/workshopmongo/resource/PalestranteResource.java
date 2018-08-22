package com.kaioferreira.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaioferreira.workshopmongo.domain.Palestrante;
import com.kaioferreira.workshopmongo.service.PalestranteService;
import com.mongodb.client.model.ReturnDocument;

@RestController
@RequestMapping(value = "/palestrantes")
public class PalestranteResource {
	
	//injetar camada de serviço do palestrante
	@Autowired
	private PalestranteService palestranteService;
	
	//metodo para buscar os palestrantes
	@RequestMapping(method = RequestMethod.GET) // ou @GetMapping
	public List<Palestrante> findAll(){
	
		List<Palestrante> palestrantesList = palestranteService.findAll();
		
		return palestrantesList;
	}
	
	
	

}
