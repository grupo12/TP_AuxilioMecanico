package ar.edu.utn.frba.tadp.auxiliomecanico.moduloGps;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.gps.Hospital;
import ar.edu.utn.frba.tadp.auxiliomecanico.gps.Lugar;
import ar.edu.utn.frba.tadp.auxiliomecanico.gps.TallerAuxiliar;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public abstract class ModeloGps {
	public abstract ModeloGps nuevoGps();
	public abstract Lugar ubicacionCamion(Camion unCamion);
	public abstract Lugar ubicacionCliente(Cliente uncliente);
	public abstract Hospital dondeQuedaHospitalMasCercano(Lugar lugarDado);
	public abstract TallerAuxiliar dondeQuedaTallerMasCercano(Lugar lugarDado);
	public abstract int distantaciaEntre(Lugar primerLugar, Lugar segundoLugar);
	public abstract Tiempo paraIrDesdeHasta(Lugar primerLugar, Lugar segundoLugar);
}
