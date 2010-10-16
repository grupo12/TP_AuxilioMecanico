package ar.edu.utn.frba.tadp.auxiliomecanico.manipularTiempoTest;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CuotaDesactualizadaException;
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
	  
	  tiempoDePrueba = tiempoDePrueba.nuevoTiempo(26, 10);;
	}
	
	@Test (expected = MinutosIncorrectos.class)
	public void quieroCrearTiempoDe61Minutos (){
	  Tiempo tiempoDePrueba= new Tiempo();
	  tiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 61);;
	}
}
