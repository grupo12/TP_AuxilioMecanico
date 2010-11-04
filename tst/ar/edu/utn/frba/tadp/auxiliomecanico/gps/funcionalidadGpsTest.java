package ar.edu.utn.frba.tadp.auxiliomecanico.gps;

import static org.junit.Assert.*;

import org.junit.Test;

public class funcionalidadGpsTest {
	
	public MockGps gps = new MockGps();

	@Test
	public void distanciEntreLujanLugano() {
		assertEquals(gps.distantaciaEntre(Lugar.lujan, Lugar.tigre), 57);

	}

	@Test
	public void distanciEntrePalermoLujan() {
		assertEquals(gps.distantaciaEntre(Lugar.palermo, Lugar.tigre), 75);
		assertEquals(gps.distantaciaEntre(Lugar.tigre, Lugar.palermo), 75);
	}

	@Test
	public void distanciEntreUrquizaTigre() {
		assertEquals(gps.distantaciaEntre(Lugar.urquiza, Lugar.tigre), 50);
	}

	@Test
	public void distanciEntreMorenoTigre() {
		assertEquals(gps.distantaciaEntre(Lugar.moreno, Lugar.tigre), 10);
	}

	@Test
	public void distanciEntreMoreno() {
		assertEquals(gps.distantaciaEntre(Lugar.moreno, Lugar.moreno), 0);
	}
}
