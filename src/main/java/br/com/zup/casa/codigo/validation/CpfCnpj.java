package br.com.zup.casa.codigo.validation;

import javax.validation.Payload;

public @interface CpfCnpj {
	
	 String message() default "CPF/CNPJ inválido";

	  Class<?>[] groups() default {};

	  Class<? extends Payload>[] payload() default {};

}
