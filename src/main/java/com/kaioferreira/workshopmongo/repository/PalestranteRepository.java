package com.kaioferreira.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kaioferreira.workshopmongo.domain.Palestrante;

public interface PalestranteRepository  extends  MongoRepository<Palestrante, String>{

}
