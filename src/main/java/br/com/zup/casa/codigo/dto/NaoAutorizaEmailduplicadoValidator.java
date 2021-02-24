package br.com.zup.casa.codigo.dto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casa.codigo.entity.Autor;
import br.com.zup.casa.codigo.repository.AutorRepository;

@Component
public class NaoAutorizaEmailduplicadoValidator implements Validator {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> classe) {
		return AutorDto.class.isAssignableFrom(classe);
		
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		AutorDto autorDto = (AutorDto) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(autorDto.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Email já cadastrado");
		}
	}
	

}
