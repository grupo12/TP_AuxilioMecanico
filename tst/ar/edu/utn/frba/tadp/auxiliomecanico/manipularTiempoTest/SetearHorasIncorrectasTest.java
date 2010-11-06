package ar.edu.utn.frba.tadp.auxiliomecanico.manipularTiempoTest;

import static org.junit.Assert.*;

import org.junit.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.excepciones.MinutosIncorrectosException;

public class SetearHorasIncorrectasTest {

/**
 * la idea es que no se pueda crear un tiempo incorrecto
 */
	public Tiempo tiempoDePrueba;
	public Tiempo segundotiempoDePrueba;
	@Before 
	public void setUp(){
		tiempoDePrueba= new Tiempo();
		segundotiempoDePrueba= new Tiempo();
		
	}
	
	@Test (expected = MinutosIncorrectosException.class)
	public void quieroCrearTiempoDe61Minutos (){
	  
		tiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 61);
	}
	
	@Test
	public void quieroCrearUnTiempoCorrecto(){
		tiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 15);

		assertEquals(tiempoDePrueba.getHoras(),10);
		assertEquals(tiempoDePrueba.getMinutos(),15);
	}
	
	@Test
	public void quieroCrearUnTiempoSumado(){
		
		tiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 45);
		segundotiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 15);
		
		tiempoDePrueba = Tiempo.sumarTiempos(tiempoDePrueba, segundotiempoDePrueba);
		
		assertEquals(tiempoDePrueba.getHoras(),21);
		assertEquals(tiempoDePrueba.getMinutos(),00);
	}
	
	@Test 
	public void convertiAminutosTest (){
	  
		tiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 10);
		assertEquals(tiempoDePrueba.aMinutos(),610);
	}

}