package br.com.zup.casa.codigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casa.codigo.entity.Autor;
import br.com.zup.casa.codigo.entity.Categoria;
import br.com.zup.casa.codigo.entity.Livro;
import br.com.zup.casa.codigo.validation.ExistsId;

public class LivroDto {

	@NotBlank
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	private String isbn;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@Min(100)
	private Integer numeroPaginas;

	@Future
	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;

	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id")
	private Long idAutor;

	@ExistsId(domainClass = Autor.class, fieldName = "id")
	@NotNull
	private Long idCategoria;

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
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

	public Long getIdAutor() {
		return idAutor;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public LivroDto(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String isbn,
			@NotBlank String sumario, @NotNull @Min(20) BigDecimal preco, @Min(100) Integer numeroPaginas,
			@Future @NotNull LocalDate dataPublicacao, @NotNull Long idAutor, @NotNull Long idCategoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.isbn = isbn;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.dataPublicacao = dataPublicacao;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;

	}

	public Livro toModel(EntityManager manager) {
		@NotNull
		Autor autor = manager.find(Autor.class, this.idAutor);
		@NotNull
		Categoria categoria = manager.find(Categoria.class, this.idCategoria);

		return new Livro(titulo, resumo, isbn, sumario, preco, numeroPaginas, dataPublicacao, autor, categoria);

	}
}