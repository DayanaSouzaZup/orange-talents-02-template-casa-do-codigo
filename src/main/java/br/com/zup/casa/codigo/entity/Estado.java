package br.com.zup.casa.codigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@ManyToOne
	@NotNull
	@Valid
	private Pais pais;

	public String getNome() {
		return nome;
	}

	public Estado(@NotBlank String nome, @NotNull @Valid Pais pais) {
		super();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}

}
