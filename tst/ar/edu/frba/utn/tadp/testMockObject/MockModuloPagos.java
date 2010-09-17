package ar.edu.frba.utn.tadp.testMockObject;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.*;

public class MockModuloPagos implements ModuloPagos {
	
	public double Deuda;
	
	public MockModuloPagos(double unaDeuda){
		this.Deuda = unaDeuda ;
	}	
	
	public void setNumeroMagico(double numeroMagico) {
		Deuda = numeroMagico;
	}

	public double moraDe(Cliente cliente){
		//Supongamos que hace una cuenta loca y devuelve un double
		return this.Deuda;
	}
}
