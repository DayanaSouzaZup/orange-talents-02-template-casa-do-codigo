package br.com.zup.casa.codigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zup.casa.codigo.entity.Categoria;
import br.com.zup.casa.codigo.validation.UniqueValue;

public class CategoriaDto {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public CategoriaDto() {
		
	}
	
	public CategoriaDto(String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		
		return new Categoria(this.nome);
	}
	
}
