package ar.edu.frba.utn.tadp.auxiliomecanico.planes;

import java.util.Collection;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public interface Plan {

	public abstract boolean isCuotaAlDia(Cliente cliente, ModuloPagos moduloPagos) ;
	
	public boolean puedeAtenderReparacionSimple();
	public boolean puedeAtenderReparacionCompleja();
	public boolean puedeAtenderRemolque();
	public Camion selectCamion(Collection<Camion> camiones);
	
}
