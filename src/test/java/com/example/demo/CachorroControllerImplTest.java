package com.example.demo;

import com.example.demo.entrypoint.json.CachorroJson;
import com.example.demo.entrypoint.json.CachorroVacinadoJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CachorroControllerImplTest {

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	@DisplayName("Deve validar cachorro com nome não preenchido")
	void deveValidarCachorroComNomeNaoPreenchido() {
		CachorroJson cachorroJson = new CachorroJson();
		cachorroJson.setIdade(10);

		Set<ConstraintViolation<CachorroJson>> violations = validator.validate(cachorroJson);

		assertTrue(!violations.isEmpty());
		assertEquals(violations.stream().findFirst().get().getMessage(),"O campo nome deve ser preenchhido");
	}

}
