package ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

public class MockModuloPagos implements ModuloPagos {
	
	public double Deuda;
	
	public MockModuloPagos(double unaDeuda){
		this.Deuda = unaDeuda ;
	}	
	
	public void setDeuda(double numeroMagico) {
		Deuda = numeroMagico;
	}

	public double moraDe(Cliente cliente){
		//Supongamos que hace una cuenta loca y devuelve un double
		return this.Deuda;
	}
}
