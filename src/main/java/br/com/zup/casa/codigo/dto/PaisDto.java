package br.com.zup.casa.codigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zup.casa.codigo.entity.Pais;
import br.com.zup.casa.codigo.validation.UniqueValue;

public class PaisDto {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public PaisDto() {
		
	}
	public PaisDto(@NotBlank String nome) {
		super();
		this.nome = nome;
	}


	public Pais toModel() {
		return null;
	}

}
