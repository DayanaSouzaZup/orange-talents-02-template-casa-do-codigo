package br.com.zup.casa.codigo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	private String isbn;

	@NotBlank
	private String sumario;

	@Min(20)
	private BigDecimal preco;

	@Min(100)
	private Integer numeroPaginas;

	@Future
	private LocalDate dataPublicacao;

	

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Autor autor;
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
	
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	@Deprecated
	public Livro() {

	}
	
	public Livro(@NotBlank String titulo2, @NotBlank @Size(max = 500) String resumo2, @NotBlank String isbn2,
			@NotBlank String sumario2, @NotNull @Min(20) BigDecimal preco2, @Min(100) Integer numeroPaginas2,
			@Future @NotNull LocalDate dataPublicacao2, @NotNull Autor autor2, @NotNull Categoria categoria2) {
		
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", isbn=" + isbn + ", sumario="
				+ sumario + ", preco=" + preco + ", numeroPaginas=" + numeroPaginas + ", dataPublicacao="
				+ dataPublicacao + ", categoria=" + categoria + ", autor=" + autor + "]";
	}

}
