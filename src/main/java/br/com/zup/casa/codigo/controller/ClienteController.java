package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.dto.ClienteDto;
import br.com.zup.casa.codigo.entity.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastraCliente (@RequestBody @Valid ClienteDto clienteDto) {
		
		Cliente novoCliente = clienteDto.toModel(manager);
		manager.persist(novoCliente);
		
		return novoCliente.toString();
	}

}
