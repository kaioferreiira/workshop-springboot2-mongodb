package com.kaioferreira.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "palestrante")
public class Palestrante {

	@Id
	private String id;
	private String nome;
	private String nomePalestra;
	
	
	public Palestrante() {
		super();
	}
	public Palestrante(String id, String nome, String nomePalestra) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomePalestra = nomePalestra;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomePalestra() {
		return nomePalestra;
	}
	public void setNomePalestra(String nomePalestra) {
		this.nomePalestra = nomePalestra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palestrante other = (Palestrante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
