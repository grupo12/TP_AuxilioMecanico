package ar.edu.utn.frba.tadp.auxiliomecanico.prestadores;

import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

public interface PrestadorServicios {

	void atenderUrgencia(Pedido pedido);

	void atender(Pedido pedido);

	int getCosto(Tiempo tiempoAtencion);

	Tiempo tiempoDePedidosPendientes();

}
