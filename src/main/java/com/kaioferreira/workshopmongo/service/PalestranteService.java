package com.kaioferreira.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaioferreira.workshopmongo.domain.Palestrante;
import com.kaioferreira.workshopmongo.repository.PalestranteRepository;

@Service
public class PalestranteService {

	@Autowired
	private PalestranteRepository palestranteRepository;
	
	//metodo para buscar todos os paletrantes
	public List <Palestrante> findAll(){
		
		return palestranteRepository.findAll();
	}
}
