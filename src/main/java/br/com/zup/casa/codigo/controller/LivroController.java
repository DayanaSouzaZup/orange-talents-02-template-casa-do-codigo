package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.dto.LivroDto;
import br.com.zup.casa.codigo.entity.Livro;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public String cadastraLivro(@RequestBody @Valid LivroDto livroDto) {
		
		Livro novoLivro = livroDto.toModel(manager);
		manager.persist(novoLivro);
		
		return novoLivro.toString();

	}

}
