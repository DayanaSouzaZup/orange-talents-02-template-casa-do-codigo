package br.com.zup.casa.codigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.dto.CategoriaDto;
import br.com.zup.casa.codigo.entity.Categoria;
import br.com.zup.casa.codigo.repository.CategoriaRepository;

@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping("/categorias")
	@Transactional
	public String cadastrarCategoria (@RequestBody @Valid CategoriaDto categoriaDto) {
		
		Categoria categoria = categoriaDto.toModel();
		categoriaRepository.save(categoria);
		return categoria.toString();
	}
}

