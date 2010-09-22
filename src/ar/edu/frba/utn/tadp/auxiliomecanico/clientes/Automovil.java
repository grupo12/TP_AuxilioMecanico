package ar.edu.frba.utn.tadp.auxiliomecanico.clientes;


public class Automovil {

	private Cliente cliente;
	private double peso;

	public Automovil(double peso, Cliente cliente) {
		this.cliente = cliente;
		this.peso = peso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public boolean esMasPesadoQue(double peso) {
		return this.peso > peso;
	}
}
