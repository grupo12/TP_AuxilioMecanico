package ar.edu.frba.utn.tadp.auxiliomecanico.clientes;

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

}
