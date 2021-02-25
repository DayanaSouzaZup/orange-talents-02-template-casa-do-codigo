package br.com.zup.casa.codigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import br.com.zup.casa.codigo.entity.Estado;
import br.com.zup.casa.codigo.entity.Pais;
import br.com.zup.casa.codigo.validation.ExistsId;
import br.com.zup.casa.codigo.validation.UniqueValue;

public class EstadoDto {

	@NotNull
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public EstadoDto(@NotNull String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	@Override
	public String toString() {
		return "EstadoDto [nome=" + nome + ", idPais=" + idPais + "]";
	}

	public Estado toModel(EntityManager manager) {
		
		@NotNull
		Pais pais = manager.find(Pais.class, this.idPais);

		return new Estado(nome, manager.find(Pais.class, idPais));
	}

}
