package br.com.zup.casa.codigo.detalhe;

import br.com.zup.casa.codigo.entity.Autor;

public class DetalhesAutorResponse {
	
	private String nome;
	private String descricao;
	
	public DetalhesAutorResponse (Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
		
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
