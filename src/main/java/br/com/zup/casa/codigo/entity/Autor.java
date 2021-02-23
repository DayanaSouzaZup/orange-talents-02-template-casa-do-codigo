package br.com.zup.casa.codigo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime hora = LocalDateTime.now();

	public Autor(Long id, 
			@NotBlank String nome, 
			@NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao, 
			LocalDateTime hora) {
		super();
		Id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.hora = hora;
	}

	
	public Long getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	@Override
	public String toString() {
		return "Autor [Id=" + Id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", hora=" + hora
				+ "]";
	}
}
