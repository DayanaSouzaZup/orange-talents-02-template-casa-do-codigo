package br.com.zup.casa.codigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.zup.casa.codigo.entity.Cliente;
import br.com.zup.casa.codigo.entity.Estado;
import br.com.zup.casa.codigo.entity.Pais;
import br.com.zup.casa.codigo.validation.CpfCnpj;
import br.com.zup.casa.codigo.validation.ExistsId;

public class ClienteDto {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CpfCnpj
	@NotBlank
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	@NotNull
	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;

	public ClienteDto(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@CPF @CNPJ @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String telefone, @NotBlank String cep, @NotNull Long idPais,
			@NotNull Long idEstado) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.idPais = idPais;
		this.idEstado = idEstado;
	}

	public Cliente toModel(EntityManager manager) {

		@NotNull
		Pais pais = manager.find(Pais.class, this.idPais);
		@NotNull
		Estado estado = manager.find(Estado.class, this.idEstado);

		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, pais,
				estado);
	}

	public ClienteDto() {

	}

	@Override
	public String toString() {
		return "ClienteDto [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade + ", telefone="
				+ telefone + ", cep=" + cep + ", idPais=" + idPais + ", idEstado=" + idEstado + "]";
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

}
