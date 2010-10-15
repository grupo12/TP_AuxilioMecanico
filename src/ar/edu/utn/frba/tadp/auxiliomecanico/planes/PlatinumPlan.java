package ar.edu.utn.frba.tadp.auxiliomecanico.planes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.MenosPedidosComparator;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class PlatinumPlan extends Plan {

	@Override
	public Camion selectCamion(Collection<Camion> camiones) {
		List<Camion> camionesOrdenados = new ArrayList<Camion>(camiones);
		
		Collections.sort(camionesOrdenados, new MenosPedidosComparator());
		
		return camionesOrdenados.get(0); 
	}

	@Override
	public double maximoMoraPara(Cliente cliente, ModuloPagos moduloPagos) {
		return cliente.getCuotaMensual();
	}

	@Override
	public void validarRemolquePara(Cliente cliente) {
		// Un cliente con plan Platinum siempre puede pedir remolque
	}
}
