package ar.edu.utn.frba.tadp.auxiliomecanico.planes.estrategias;

import java.util.ArrayList;
import java.util.Collections;

import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;

public class EstrategiaRapida implements ISelectorEstrategias{

	@Override
	public void elegirEstrategia(ArrayList<Estrategia> estrategias) {
		Collections.sort(estrategias, new ComparadorRapidez());
		estrategias.get(1).atender();
	}


}