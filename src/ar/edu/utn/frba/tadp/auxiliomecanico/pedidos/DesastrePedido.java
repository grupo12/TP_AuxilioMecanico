packagege ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

public abstract class DesastrePedido extends Pedido {
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public abstract class DesastrePedido extends EspecialidadPedido {

	public DesastrePedido(Pedido sujeto) {
		super(sujeto);
	}

	@Override
	public abstract boolean puedoAtenderte(Camion camion);

	public abstract void terminarServicioDelPedido(Tiempo tiempo);

	public abstract Tiempo calcularTiempoDeAtencion();

}
