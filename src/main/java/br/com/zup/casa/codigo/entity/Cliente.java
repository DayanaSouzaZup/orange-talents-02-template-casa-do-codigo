package br.com.zup.casa.codigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CPF
	@CNPJ
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

	@ManyToOne
	private Pais paisCadastrado;

	@ManyToOne
	private Estado estadoCadastrado;

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@CPF @CNPJ @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String telefone, @NotBlank String cep, Pais paisCadastrado,
			Estado estadoCadastrado) {
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
		this.paisCadastrado = paisCadastrado;
		this.estadoCadastrado = estadoCadastrado;
	}

	public Cliente() {

	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", telefone=" + telefone + ", cep=" + cep + ", paisCadastrado=" + paisCadastrado
				+ ", estadoCadastrado=" + estadoCadastrado + "]";
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

}
