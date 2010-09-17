package ar.edu.frba.utn.tadp.auxiliomecanico.planes;

import java.util.Collection;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class PlatiniumPlan implements Plan {
	private double cuotaMensual;
	
	public PlatiniumPlan(double cuotaMensual){
		this.cuotaMensual = cuotaMensual;
	}
	
	@Override
	public boolean isCuotaAlDia(Cliente cliente, ModuloPagos moduloPagos) {
		return (moduloPagos.moraDe(cliente)<= (this.cuotaMensual)) ;
	}

	@Override
	public boolean puedeAtenderReparacionSimple() {
		return true;
	}

	@Override
	public boolean puedeAtenderReparacionCompleja() {
		return true;
	}

	@Override
	public boolean puedeAtenderRemolque() {
		return true;
	}

	@Override
	public Camion selectCamion(Collection<Camion> camiones) {
		// TODO Auto-generated method stub
		return null;
	}

}
