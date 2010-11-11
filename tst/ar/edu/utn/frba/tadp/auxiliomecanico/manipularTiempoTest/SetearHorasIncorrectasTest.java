package ar.edu.utn.frba.tadp.auxiliomecanico.manipularTiempoTest;

import static org.junit.Assert.*;

import org.junit.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Excepciones.MinutosIncorrectosException;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Excepciones.ValorEscalarIncorrectoException;

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

	@Test
	public void quieroCrearUnTiempoConOverflowDeMinutos(){
		tiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 150);

		assertEquals(tiempoDePrueba.getHoras(),12);
		assertEquals(tiempoDePrueba.getMinutos(),30);
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
	public void quieroCrearUnTiempoSumados(){
		
		tiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 45);
		segundotiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 110);
		
		tiempoDePrueba = Tiempo.sumarTiempos(tiempoDePrueba, segundotiempoDePrueba);
		
		assertEquals(tiempoDePrueba.getHoras(),22);
		assertEquals(tiempoDePrueba.getMinutos(),35);
	}
	@Test 
	public void convertiAminutosTest (){
	  
		tiempoDePrueba = tiempoDePrueba.nuevoTiempo(10, 10);
		assertEquals(tiempoDePrueba.aMinutos(),610);
	}
	@Test
	public void multiplicarPorCero(){
		
		Tiempo.multiplicarTiempo(tiempoDePrueba.nuevoTiempo(10, 10),0); 
		assertEquals(tiempoDePrueba.getHoras(),0);
		assertEquals(tiempoDePrueba.getMinutos(),0);
	}
	@Test
	public void multiplicarPorPositivo(){
		
		tiempoDePrueba = Tiempo.multiplicarTiempo(tiempoDePrueba.nuevoTiempo(10, 10),10); 
		assertEquals(tiempoDePrueba.getHoras(),101);
		assertEquals(tiempoDePrueba.getMinutos(),40);
	}
	
	@Test(expected = MinutosIncorrectosException.class)
	public void multiplicarPorNegativo(){

		tiempoDePrueba = Tiempo.multiplicarTiempo(tiempoDePrueba.nuevoTiempo(10, 10),-10); 
	}
	
	@Test
	public void promediarTiempos(){
		tiempoDePrueba = Tiempo.multiplicarTiempo(new Tiempo().nuevoTiempo(2, 27),3);
		
		tiempoDePrueba = Tiempo.promediarTiempo(tiempoDePrueba, 3);
		assertEquals(tiempoDePrueba.getHoras(),2);
		assertEquals(tiempoDePrueba.getMinutos(),27);
	}
	
	@Test( expected = ValorEscalarIncorrectoException.class)
	public void promediarTiemposConValoresIncorrectos(){
		tiempoDePrueba = Tiempo.multiplicarTiempo(new Tiempo().nuevoTiempo(2, 27),3);
		
		tiempoDePrueba = Tiempo.promediarTiempo(tiempoDePrueba, 0);
	}
}
