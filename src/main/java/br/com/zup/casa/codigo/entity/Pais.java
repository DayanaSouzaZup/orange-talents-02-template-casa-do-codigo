package br.com.zup.casa.codigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotBlank
	private String nome;

	public Long getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

	@Deprecated
	public Pais() {

	}

	public Pais(Long id, @NotBlank String nome) {
		super();
		Id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pais [Id=" + Id + ", nome=" + nome + "]";
	}

}
