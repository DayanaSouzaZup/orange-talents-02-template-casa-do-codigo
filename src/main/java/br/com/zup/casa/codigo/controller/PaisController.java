package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.dto.PaisDto;
import br.com.zup.casa.codigo.entity.Pais;

@RestController
public class PaisController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/paises")
	@Transactional

	public String cadastraPais(@RequestBody @Valid PaisDto paisDto) {

		Pais paisCadastrado = new Pais(null, paisDto.getNome());
		manager.persist(paisCadastrado);
		return paisCadastrado.toString();
	}

}
