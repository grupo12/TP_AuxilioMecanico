package ar.edu.frba.utn.tadp.testMockObject;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.modulopagos;

public class MockModuloPagos implements ModuloPagos {
	
	//public Collection<Cliente> clientes = Cliente;
	public double NumeroMagico=200;
	
	public double moraDe(Cliente cliente){
		//Supongamos que hace una cuenta loca y devuelve un double
		return this.NumeroMagico;
	}
}
