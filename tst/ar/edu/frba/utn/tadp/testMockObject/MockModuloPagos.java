package ar.edu.frba.utn.tadp.testMockObject;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.*;

public class MockModuloPagos implements ModuloPagos {
	
	public double NumeroMagico;
	
	public MockModuloPagos(){
		this.NumeroMagico= 0 ;
	}	
	
	public void setNumeroMagico(double numeroMagico) {
		NumeroMagico = numeroMagico;
	}

	public double moraDe(Cliente cliente){
		//Supongamos que hace una cuenta loca y devuelve un double
		return this.NumeroMagico;
	}
}
