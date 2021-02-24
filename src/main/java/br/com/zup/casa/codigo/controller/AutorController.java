package br.com.zup.casa.codigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.dto.AutorDto;
import br.com.zup.casa.codigo.dto.NaoAutorizaEmailduplicadoValidator;
import br.com.zup.casa.codigo.entity.Autor;
import br.com.zup.casa.codigo.repository.AutorRepository;

@RestController
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private NaoAutorizaEmailduplicadoValidator naoAutorizaEmailduplicadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(naoAutorizaEmailduplicadoValidator);
		}
	
	@PostMapping("/autores")
	@Transactional
	public String cadastrarAutor (@RequestBody @Valid AutorDto autorDto) {
		
		Autor autor = autorDto.toModel();
		autorRepository.save(autor);
		return autor.toString();
		
	}
}
