package ar.edu.utn.frba.tadp.auxiliomecanico.gps;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.moduloGps.ModeloGps;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MockGps extends ModeloGps{
private MockGps Gps;
private List<TallerAuxiliar>  talleresConocidos;
private List<Hospital>  hospitalesConocidos;
private Tiempo minutosPorUnidadKilometros = new Tiempo().nuevoTiempo(0, 5);

/*Singleton para la creacion del gps*/
@Override
public MockGps nuevoGps(){
	if (this.Gps == null){
		MockGps gps = new MockGps();
		gps.setearTalleresConocido();
		gps.setearHospitalesConocido();
		Gps=gps;
		return this.Gps;
	}
	else 
		return this.Gps;
}

private void setearTalleresConocido(){
	this.talleresConocidos = new LinkedList<TallerAuxiliar>() ;
	talleresConocidos.add(TallerAuxiliar.tallerPM);
	talleresConocidos.add(TallerAuxiliar.sanchezSolucionesMecánicas);
	talleresConocidos.add(TallerAuxiliar.levelCars);
	talleresConocidos.add(TallerAuxiliar.autoproSA);
	talleresConocidos.add(TallerAuxiliar.bonattiTeamRacing);
	talleresConocidos.add(TallerAuxiliar.gabrielFalzone);
}

private void setearHospitalesConocido(){
	this.hospitalesConocidos = new LinkedList<Hospital>() ;
	hospitalesConocidos.add(Hospital.HospitalCeciliaGrierson);
	hospitalesConocidos.add(Hospital.HospitalFernadez);
	hospitalesConocidos.add(Hospital.HospitalGuemes);
	hospitalesConocidos.add(Hospital.HospitalMarianoYLucianoDeLavega);
	hospitalesConocidos.add(Hospital.Hospitalpirovano);
	hospitalesConocidos.add(Hospital.HospitalTigre);
}
@Override
public int distantaciaEntre(Lugar primerLugar, Lugar segundoLugar){
	int distancia = 0;
	if (primerLugar == segundoLugar){return distancia=0;};
	if ((primerLugar==Lugar.moreno))
		if (segundoLugar == Lugar.lujan){return distancia=33;}
		else {
			if (segundoLugar == Lugar.palermo){return distancia=23;}
			else {
				if(segundoLugar == Lugar.lugano){return distancia=18;}
				else{
					if ( segundoLugar == Lugar.urquiza){return distancia=73;}
					else {
						if (segundoLugar == Lugar.tigre){return distancia=10;}
					}
				}
				
			}
		}
		

	if (primerLugar == Lugar.lujan)
		if(segundoLugar == Lugar.palermo){return distancia=90;}
		else{
			if (segundoLugar == Lugar.lugano){return distancia=70;}
			else {
				if ( segundoLugar == Lugar.urquiza){return distancia=87;}
				else{
					if(segundoLugar == Lugar.tigre){return distancia=57;}
				}
			}
		}
	
	if (primerLugar == Lugar.palermo)
		if (segundoLugar == Lugar.lugano){return distancia=15;}
		else{
			if(segundoLugar==Lugar.urquiza){return distancia=45;}
			else if(segundoLugar==Lugar.tigre){return distancia=75;}
		}
	
	if (primerLugar == Lugar.lugano)
		if (segundoLugar == Lugar.urquiza){return distancia=60;}
		else {if(segundoLugar== Lugar.tigre){return distancia=40;}}
	
	if (primerLugar == Lugar.urquiza)
		{if (segundoLugar==Lugar.tigre){return distancia=50;}}
	else{ 
		return distancia = distantaciaEntre (segundoLugar, primerLugar);
	};
	
	return distancia;
}
@Override
public Lugar ubicacionCamion(Camion unCamion){
	int numero = 3;
	switch(numero){
	case(0):{return Lugar.moreno;}
	case(1):{return Lugar.palermo;}
	case(2):{return Lugar.lugano;}
	case(3):{return Lugar.tigre;}
	case(4):{return Lugar.urquiza;}
	case(5):{return Lugar.lujan;}
	default :{return Lugar.lujan;}
	}
}
public Tiempo getMinutosPorUnidadKilometros() {
	return minutosPorUnidadKilometros;
}

public void setMinutosPorUnidadKilometros(Tiempo minutosPorUnidadKilometros) {
	this.minutosPorUnidadKilometros = minutosPorUnidadKilometros;
}
/*
 * Coincidamos que el metodo tiene la misma implementacion que ubicacionCamion
 * y que no se usa el Parametro unCliente , pero al tratarse de un mock object 
 * lo mas importante no es que la implementacion sino la interfaz del objeto gps
 * */
@Override
public Lugar ubicacionCliente(Cliente uncliente){
	int numero = 0;
	switch(numero){
	case(0):{return Lugar.moreno;}
	case(1):{return Lugar.palermo;}
	case(2):{return Lugar.lugano;}
	case(3):{return Lugar.tigre;}
	case(4):{return Lugar.urquiza;}
	case(5):{return Lugar.lujan;}
	default :{return Lugar.lujan;}
	}
}
private Lugar dondeQuedaHospital(Hospital hospital){
return hospital.getDondeEsta();
}

private Lugar dondeQuedaTaller(TallerAuxiliar taller){
	return taller.getDondeEsta();
}

@Override
public Hospital dondeQuedaHospitalMasCercano(Lugar lugarDado){
	Iterator  <Hospital> iterador = hospitalesConocidos.iterator() ;
	Hospital hospitalRetorno;
	
	while( iterador.hasNext()){
		hospitalRetorno = iterador.next();
		if ( hospitalRetorno.getDondeEsta() == lugarDado)
			return hospitalRetorno;
	 }
	return Hospital.noHospital ;
}

@Override
public TallerAuxiliar dondeQuedaTallerMasCercano(Lugar lugarDado){
	Iterator  <TallerAuxiliar> iterador = talleresConocidos.iterator() ;
	TallerAuxiliar tallerRetorno;
	
	while( iterador.hasNext()){
		tallerRetorno = iterador.next();
		if ( tallerRetorno.getDondeEsta() == lugarDado)
			return tallerRetorno;
	 }
	return TallerAuxiliar.noTaller ;
}

@Override
public Tiempo paraIrDesdeHasta(Lugar primerLugar, Lugar segundoLugar){
	
	return Tiempo.multiplicarTiempo(minutosPorUnidadKilometros,distantaciaEntre(primerLugar , segundoLugar));

}
}