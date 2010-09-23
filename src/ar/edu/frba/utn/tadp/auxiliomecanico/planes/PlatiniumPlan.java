package ar.edu.frba.utn.tadp.auxiliomecanico.planes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.MenosPedidosComparator;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class PlatiniumPlan extends Plan {

	@Override
	public boolean esValidoRemolquePara(Cliente cliente) {
		return true;
	}

	@Override
	public Camion selectCamion(Collection<Camion> camiones) {
		List<Camion> camionesOrdenados = new ArrayList<Camion>(camiones);
		
		Collections.sort(camionesOrdenados, new MenosPedidosComparator());
		
		return camionesOrdenados.get(0); 
	}

	@Override
	protected double maximoMora(Cliente cliente, ModuloPagos moduloPagos) {
		return cliente.getCuotaMensual();
	}
}
