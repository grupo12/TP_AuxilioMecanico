package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public abstract class DesastrePedido extends Pedido {

	public abstract Tiempo calcularTiempoDeAtencion();
}
