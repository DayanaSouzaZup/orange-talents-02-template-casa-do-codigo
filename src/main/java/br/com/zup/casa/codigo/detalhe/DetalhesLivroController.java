package br.com.zup.casa.codigo.detalhe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.entity.Livro;

@RestController
public class DetalhesLivroController {
	
	@PersistenceContext
	EntityManager manager;
	
	@GetMapping(value = "/produtos{id}")
	public ResponseEntity<?> detalhe (@PathVariable("id") Long id) {
		
		Livro livroProcurado = manager.find(Livro.class, id);
		
		if(livroProcurado ==null) {
			return ResponseEntity.notFound().build();			
		}
		
		DetalhesLivroResponse detalhesLivroResponse = new DetalhesLivroResponse(livroProcurado);
		return ResponseEntity.ok(detalhesLivroResponse);
		
	}

}
