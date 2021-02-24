package br.com.zup.casa.codigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casa.codigo.entity.Autor;

public class AutorDto {
	

	@NotBlank(message = "Campo nome não pode ser em branco")
	private String nome;

	@NotBlank(message = "Campo email não pode ser em branco")
	@Email
	private String email;

	@NotBlank(message = "Campo descrição não pode ser em branco")
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

	public String getEmail() {
		
		return this.email;
	}
	

}
