package ar.edu.utn.frba.tadp.auxiliomecanico.gps;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

import java.util.ArrayList;
import java.util.Random;
public class MockGPS {
private MockGPS Gps;
private ArrayList<TallerAuxiliar>  talleresConocidos;

/*Singleton para la creacion del gps*/
public MockGPS nuevoGps(){
	if (this.Gps == null){
		MockGPS gps = new MockGPS();
		gps.setearTalleresConocido();
		Gps=gps;
		return this.Gps;
	}
	else 
		return this.Gps;
}

private void setearTalleresConocido(){
	talleresConocidos.add(TallerAuxiliar.tallerPM);
	talleresConocidos.add(TallerAuxiliar.sanchezSolucionesMecánicas);
	talleresConocidos.add(TallerAuxiliar.levelCars);
	talleresConocidos.add(TallerAuxiliar.autoproSA);
	talleresConocidos.add(TallerAuxiliar.bonattiTeamRacing);
	talleresConocidos.add(TallerAuxiliar.gabrielFalzone);
}
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

public Lugar ubicacionCamion(Camion unCamion){
	Random rand = new Random();
	int numero = (int)((rand.nextInt()%6)*6);
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

/*
 * Coincidamos que el metodo tiene la misma implementacion que ubicacionCamion
 * y que no se usa el Parametro unCliente , pero al tratarse de un mock object 
 * lo mas importante no es que la implementacion sino la interfaz del objeto gps
 * */
public Lugar ubicacionCliente(Cliente uncliente){
	Random rand = new Random();
	int numero = (int)((rand.nextInt()%6)*6);
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

public Lugar dondeQuedaMasCercano(Hospital hospital){
	
	return Lugar.lujan;
}

public Lugar dondeQuedaMasCercano(TallerAuxiliar taller){
	
	return Lugar.lujan;
}
}