package ar.edu.utn.frba.tadp.auxiliomecanico.manipularTiempoTest;

import static org.junit.Assert.*;

import org.junit.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Excepciones.HorasIncorrectas;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Excepciones.MinutosIncorrectos;

public class SetearHorasIncorrectasTest {

/**
 * la idea es que no se pueda crear un tiempo incorrecto
 */
	@Test (expected = HorasIncorrectas.class)
	public void quieroCrearTiempoDe26Horas (){
	  Tiempo tiempoDePrueba= new Tiempo();
	  
	  tiempoDePrueba = tiempoDePrueba.nuevoTiempo(26, 10);
	}
	
	@Test (expected = MinutosIncorrectos.class)
	public void quieroCrearTiempoDe61Minutos (){
	  Tiempo tiempoDePrueba= new Tiempo();
	  tiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 61);
	}
	
	@Test
	public void quieroCrearUnTiempoCorrecto(){
		Tiempo tiempoDePrueba= new Tiempo();
		tiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 15);

		assertEquals(tiempoDePrueba.getHoras(),10);
		assertEquals(tiempoDePrueba.getMinutos(),15);
	}
}
