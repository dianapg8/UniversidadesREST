package com.ibm.academia.apirest.UniversidadesRest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UniversidadesRestApplicationTests {

	@Test
	@DisplayName("Test: Suma de valores")
	void sumaValores()
	{
		Calculadora calculadora = new Calculadora();

		//Given -> define contexto o precondiciones
		Integer valorA = 2;
		Integer valorB = 3;

		//when -> ejecuta la accion
		Integer expected = calculadora.sumar(valorA, valorB);

		//then -> validar que funciona
		Integer resultadoEsperado = 5;
		assertThat(expected).isEqualTo(resultadoEsperado);
	}

	class Calculadora
	{
		Integer sumar(Integer a, Integer b)
		{
			return a+b;
		}
	}

}