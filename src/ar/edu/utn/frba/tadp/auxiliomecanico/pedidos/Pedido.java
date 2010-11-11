package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;



import java.util.Collection;


import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.gps.Lugar;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.moduloGps.modeloGps;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

/**
 * SSSSSSSSSSSSSSSSSSSSSSs Representa un pedido dado, realizado por un cliente
 * al sistema de auxilio mecánico.
 * 
 */
public abstract class Pedido {

	private static ModuloPagos ModuloDePagos;
	private double economicidad;
	private static modeloGps gps;
	public Camion camionAtendio;
	/**
	 * Realiza todas las operaciones correspondientes a la validación del mismo
	 * en el sistema.
	 */
	public void validar() {
		this.validarExistenciaModuloPagos();
		this.validarCliente();
	}

	/**
	 * Realiza todas las validaciones del pedido en relación al cliente que lo
	 * solicita.
	 */
	private void validarCliente() {
		Cliente cliente = this.getCliente();
		cliente.validarCuotaAlDia(ModuloDePagos);
		this.validarEspecialidadPara(cliente);
	}

	/**
	 * Valida que haya efectivamente un módulo de pagos establecido.
	 */
	private void validarExistenciaModuloPagos() {
		if (ModuloDePagos == null)
			throw new ModuloPagosFaltanteException("No se inicializó el módulo de pagos del taller");
	}

	/**
	 * Realiza las validaciones específicas de cada especialidad de pedido sobre
	 * el cliente.
	 * 
	 * @param cliente
	 *            Cliente que solicita el pedido
	 */
	protected abstract void validarEspecialidadPara(Cliente cliente);

	/**
	 * Determina si el mismo es posible ser atendido por un camión dado.
	 * 
	 * @param unCamion
	 *            Camión candidato a atender el pedido
	 * @param automovil
	 *            Automóvil para el cual se solicitó el pedido
	 * @return Puede o no puede
	 */
	public abstract boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil);

	/**
	 * Responde si el pedido es simple.
	 * 
	 * @return <b>true</b> - Es simple<br>
	 *         <b>false</b> - No es simple
	 */
	public abstract boolean isReparacionSimple();

	/**
	 * Responde si el pedido es de remolque.
	 * 
	 * @return <b>true</b> - Es de remolque<br>
	 *         <b>false</b> - No es de remolque
	 */
	public abstract boolean isRemolque();

	public abstract Cliente getCliente();

	public abstract Automovil getAutomovil();

	public static void setModuloPagos(ModuloPagos moduloDePagos) {
		ModuloDePagos = moduloDePagos;
	}

	/**
	 * FALTA IMPLEMENTAR TAMBIEN Determina el tiempo que tarda un tipo de pedido
	 *Determina el tiempo que tarda un tipo de pedido
	 * en ser atendido
	 * 
	 * @param pedido
	 *            Pedido a calcular tiempo
	 * @return Tiempo
	 */
	public abstract Tiempo calcularTiempoDeAtencion();


	/**
	 * A diferencia de finalizar pedido , terminar se ocupa de trabajo necesario
	 * que hay que llevar a cabo para que la instancia de pedido este terminada,
	 * dando la posibilidad de luego finalizarla
	 * 
	 * @param tiempo
	 */
	public abstract void terminarServicioDelPedido(Tiempo tiempo);

	public double getEconomicidad() {
		return economicidad;
	}

	public void aumentarEconomicidad(double economicidad) {
		this.economicidad += economicidad;
	}
	
	public Tiempo CuantoTardasEnTerminarte() {
		return gps.paraIrDesdeHasta(gps.ubicacionCliente(this.getCliente()), gps.ubicacionCamion(this.camionAtendio));
	}
	
	/*Todos los servicios deben terminarse utilizando esta funcion la cual avisa al cliente y 
	 * además realiza la operatoria necesaria para sumar los tiempos
	 * */
	public void finalizar(Tiempo tiempo) {
		
		this.terminarServicioDelPedido(tiempo);
	}
	
	public abstract boolean puedeSerAtendidoPorCamiones(Collection<Camion> camiones);
	
	public abstract boolean algunCamionPuedeResolver(Collection<Camion> camiones);
	
	public abstract boolean seComplementan(Collection<Camion> camiones, Camion camion);

	public Collection<Estrategia> estrategiasAtencionEn(TallerMecanico tallerMecanico) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		// taller camiones para atender (especialidad propia)
		// una colección de camiones por especialidad (salvo el pedidobase que está todo mal)
		// con esas colecciones, buscar las distintas variaciones para atender el pedido (armar TODAS las estrategias)
		// a cada estrategia (colección de camiones) asSet, new HashSet<Camion>(colección de camiones con repetidos)
	}


	public static void setGps(modeloGps gps) {
		Pedido.gps = gps;
	}

	public static modeloGps getGps() {
		return gps;
	}

	public void setCamion(Camion camionParaAsignarA) {
		camionAtendio = camionParaAsignarA;
	}

}
