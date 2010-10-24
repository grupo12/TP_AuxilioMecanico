package ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo;

import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Excepciones.*;
/**
 * La idea de la clase tiempo es poder manejar horas y minutos de manera independiente, y si el dia de
 * mañana se encuentra una solucion mejor para la manipulacion del tiempo se puede solo cambiar la clase
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
	if ( (hora<0) ){
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

public static Tiempo sumarTiempos(Tiempo primerTiempo, Tiempo sumando) {
	int minutos=0;
	int horas=0;
	Tiempo tiempoDeRetorno= new Tiempo();
	//Primero sumamos los minutos teniendo en cuenta el overflow de los mismos
	minutos = primerTiempo.minutos + sumando.minutos;
	if ( minutos>60 ){
		horas = (minutos / 60);
		minutos= ((minutos % 60)*60);
	}else if (minutos==60){
		minutos=0;
		horas= 1;
	}
	//procedemos a sumar las horas
	horas += primerTiempo.horas + sumando.horas ; 
	tiempoDeRetorno.nuevoTiempo(horas, minutos);

return tiempoDeRetorno.nuevoTiempo(horas, minutos);
}

public int aMinutos(){
int minutosTotales=0;
	minutosTotales=(horas*60)+minutos;
return minutosTotales;
}

public double costoPara(double precioServicio) {
int minutos=this.aMinutos();

return (precioServicio*minutos);
}

}
