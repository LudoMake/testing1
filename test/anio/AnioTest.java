package anio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.DebeSerPositivoException;
import utilidades.Funciones;

class AnioTest {

	@Test
	void testBisiesto() throws DebeSerPositivoException {
		assertTrue(Funciones.esBisiesto(2024), "Este año es bisiesto");
		assertFalse(Funciones.esBisiesto(2025), "Este año no es bisiesto");
		assertFalse(Funciones.esBisiesto(1300), "Este año es bisiesto");
		assertThrows(DebeSerPositivoException.class, ()->Funciones.esBisiesto(-1), "Este año no es bisiesto");
	}
	
	@Test
	void testDiagnostico() throws DebeSerPositivoException { //assertequal porque es string
		assertThrows(DebeSerPositivoException.class, ()->Funciones.getDiagnostico(-1), "Peso inexistente");
		assertEquals("Bajo Peso",Funciones.getDiagnostico(17), "Bajo peso");
		assertEquals("Peso normal (saludable)",Funciones.getDiagnostico(23), "Peso normal");
		assertEquals("Sobrepeso",Funciones.getDiagnostico(28), "Sobrepeso");
		assertEquals("Obesidad premórbida",Funciones.getDiagnostico(39), "Obesidad premorbida");
		assertEquals("Obesidad mórbida",Funciones.getDiagnostico(41), "Obesidad morbida");

	}

	@BeforeAll //estos si van con static
	public static void inicializar() {
		System.out.println("Iniciando test...");
	}
	
	@AfterAll //estos si van con static
	public static void finalizar() {
		System.out.println("Liberando los recursos...");
	}
	
	@BeforeEach //estos van sin static
	public void inicioTest() {
		System.out.println("Iniciando nuevos test...");
	}
	
	@AfterEach //estos van sin static
	public void finTest() {
		System.out.println("Finalizando los test...");
	}
}
