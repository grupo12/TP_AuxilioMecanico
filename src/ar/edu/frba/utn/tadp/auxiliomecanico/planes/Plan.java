package ar.edu.frba.utn.tadp.auxiliomecanico.planes;

import java.util.Collection;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public abstract class Plan {

	public boolean isCuotaAlDia(Cliente cliente, ModuloPagos moduloPagos) {
		return moduloPagos.moraDe(cliente)<= this.maximoMora(cliente, moduloPagos);
	}

	protected abstract double maximoMora(Cliente cliente, ModuloPagos moduloPagos);

	public boolean esValidoReparacionSimplePara(Cliente cliente) {
		return true;
	}
	
	public boolean esValidoReparacionComplejaPara(Cliente cliente) {
		return true;
	}
	
	public abstract boolean esValidoRemolquePara(Cliente cliente);

	public abstract Camion selectCamion(Collection<Camion> camiones);
}
