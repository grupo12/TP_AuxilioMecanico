package ar.edu.frba.utn.tadp.auxiliomecanico.clientes;

import ar.edu.frba.utn.tadp.auxiliomecanico.planes.Plan;

public class Automovil {

	private Cliente cliente;
	private double peso;
	
	public Automovil(double peso, Cliente cliente) {
		this.peso = peso;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Plan getPlan(){
		return this.cliente.getPlan();
	}
}
