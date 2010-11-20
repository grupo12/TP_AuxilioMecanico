package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import java.util.Collection;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.NoSePuedeAtenderEspecialidadException;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

/**
 * Decorador abstracto de un pedido. Por defecto, delega al sujeto (el pedido
 * real) todas sus responsabilidades.
 * 
 */
public abstract class EspecialidadPedido extends Pedido {

	protected Pedido sujeto;

	public EspecialidadPedido(Pedido sujeto) {
		this.sujeto = sujeto;
	}

	public boolean isReparacionSimple() {
		return false;
	}

	public boolean isRemolque() {
		return sujeto.isRemolque();
	}

	@Override
	protected void validarEspecialidadPara(Cliente cliente) {
		this.doValidarEspecialidadPara(cliente);
		this.sujeto.validarEspecialidadPara(cliente);
	}

	protected void doValidarEspecialidadPara(Cliente cliente) {
		// Por defecto se validan las especialidades para todos los clientes
	}

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return this.doPuedeSerAtendidoPorCamion(unCamion, automovil)
				|| this.sujeto.puedeSerAtendidoPorCamion(unCamion, automovil);
	}

	/**
	 * Responde únicamente para el decorador dado si puede ser o no atentido por
	 * un camión.
	 * 
	 * @param unCamion
	 *            Camión candidato a resolver el mismo
	 * @param automovil
	 *            Automóvil a ser atendido
	 * @return Booleano
	 */
	protected abstract boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil);

	public Cliente getCliente() {
		return this.sujeto.getCliente();
	}

	public Automovil getAutomovil() {
		return this.sujeto.getAutomovil();
	}

	@Override
	public boolean puedeSerAtendidoPorCamiones(Collection<Camion> camiones) {
		return this.algunCamionPuedeResolver(camiones) && sujeto.puedeSerAtendidoPorCamiones(camiones);
	}

	@Override
	public boolean algunCamionPuedeResolver(Collection<Camion> camiones) {
		for (Camion camion : camiones) {
			if (this.puedeSerAtendidoPorCamion(camion, this.getAutomovil()))
				return true;
		}
		return false;
	}

	@Override
	public boolean seComplementan(Collection<Camion> camiones, Camion camion) {
		return ((!this.algunCamionPuedeResolver(camiones) && this
				.puedeSerAtendidoPorCamion(camion, this.getAutomovil())) || sujeto.seComplementan(camiones, camion));
	}

	public abstract void terminarServicioDelPedido(Tiempo tiempo);

	public abstract Tiempo calcularTiempoDeAtencion();

	@Override
	protected List<List<PrestadorServicios>> prestadoresParaAtenderPorEspecialidad(TallerMecanico tallerMecanico,
			Pedido pedidoOriginal) {
		List<List<PrestadorServicios>> camionesParaAtenderPorEspecialidad = this.sujeto
				.prestadoresParaAtenderPorEspecialidad(tallerMecanico, this);

		final List<PrestadorServicios> camionesParaAtenderEspecialidad = tallerMecanico
				.camionesParaAtenderEspecialidad(this);

		if (camionesParaAtenderEspecialidad.isEmpty())
			throw new NoSePuedeAtenderEspecialidadException("No se puede atender la especialidad", this);

		camionesParaAtenderPorEspecialidad.add(camionesParaAtenderEspecialidad);

		return camionesParaAtenderPorEspecialidad;
	}

	/**
	 * Verifica si un camión puede atender a la especialidad de pedido concreta.
	 * 
	 * @param camion
	 *            Camion para atender especialidad
	 * @return Valor de verdad representante de la operación
	 */
	public boolean puedeAtenderte(Camion camion) {
		return this.doPuedeSerAtendidoPorCamion(camion, this.getAutomovil());
	}

	public boolean tieneUrgencias() {
		return false;
	}

	@Override
	public boolean isIncendio() {
		return sujeto.isIncendio();
	}

	@Override
	public boolean isInundacion() {
		return sujeto.isInundacion();
	}

}
