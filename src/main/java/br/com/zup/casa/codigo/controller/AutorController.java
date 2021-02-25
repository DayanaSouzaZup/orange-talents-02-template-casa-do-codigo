package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.dto.AutorDto;
import br.com.zup.casa.codigo.entity.Autor;

@RestController
public class AutorController {
	
	@PersistenceContext
    private EntityManager manager;
	
	@PostMapping("/autores")
	@Transactional
	public String cadastrarAutor (@RequestBody @Valid AutorDto autorDto) {
		
		Autor autor = autorDto.toModel();
		manager.persist(autor);
		return autor.toString();
		
	}
}
