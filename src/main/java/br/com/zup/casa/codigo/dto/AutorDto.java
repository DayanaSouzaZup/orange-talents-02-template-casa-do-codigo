package br.com.zup.casa.codigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casa.codigo.entity.Autor;

public class AutorDto {
	

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorDto(@NotBlank String nome, 
			@NotBlank @Email String email, 
			@NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		
		return new Autor(null, this.nome, this.email, this.descricao, null);
	}
	

}
