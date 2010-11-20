package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.EspecialidadPedido;

public class NoSePuedeAtenderEspecialidad extends UserException {
	private final EspecialidadPedido especialidadPedido;

	public NoSePuedeAtenderEspecialidad(EspecialidadPedido especialidadPedido) {
		this.especialidadPedido = especialidadPedido;
	}

	private static final long serialVersionUID = 1L;

	public EspecialidadPedido getEspecialidadPedido() {
		return especialidadPedido;
	}

}
