package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public abstract class DesastrePedido extends EspecialidadPedido {

	public DesastrePedido(Pedido sujeto) {
		super(sujeto);
	}

	public abstract void terminarServicioDelPedido(Tiempo tiempo);

	public abstract Tiempo calcularTiempoDeAtencion();

}
