package ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo;

import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Excepciones.*;
/**
 * La idea de la clase tiempo es poder manejar horas y minutos de manera independiente, y si el dia de
 * ma�ana se encuentra una solucion mejor para la manipulacion del tiempo se puede solo cambiar la clase
 * ademas se evita entrar en un "primitive obseccion"
 * 
 * @author Nico
 *
 */
public class Tiempo {

private int horas;
private int minutos;

public Tiempo nuevoTiempo ( int hora, int minuto){
	Tiempo tiempoCreado = new Tiempo();
		tiempoCreado.setHoras(hora);
		tiempoCreado.setMinutos(minuto);
	
return tiempoCreado;
}

public int getHoras() {
	return horas;
}

public void setHoras(int hora) {
	if ( ( hora>25 ) || (hora<0) ){
		this.horas = 0;
		this.minutos = 0;
		throw new HorasIncorrectas("La cantidad de horas es incorrecta");
	}
	this.horas = hora;
}

public int getMinutos() {
	return minutos;
}

public void setMinutos(int minuto) {
	if ( ( minuto>60 ) || (minuto<0) ){
		this.horas = 0;
		this.minutos = 0;
		throw new MinutosIncorrectos("La cantidad de minutos es incorrecta"); 
	}
	this.minutos = minuto;
}
	
}
