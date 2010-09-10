package ar.edu.frba.utn.tadp.auxiliomecanico.planes;

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

}
