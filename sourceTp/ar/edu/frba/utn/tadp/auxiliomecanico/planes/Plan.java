package ar.edu.frba.utn.tadp.auxiliomecanico.planes;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public interface Plan {

	public abstract boolean isCuotaAlDia(Cliente cliente, ModuloPagos moduloPagos) ;
	
}
