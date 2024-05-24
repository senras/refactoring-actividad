package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private GeneradorStrategy generador = new GeneradorUltimo();


	//DUDA: Hacer un constructor que reciba los parametros de la línea y el tipo de generador? En vez de tener las variables inicializadas por fuera

	public SortedSet<String> getLineas() {
		return lineas;
	}

	//NUEVO. agrego la lógica de agregarNumeroTelefono aquí, y quito la variable booleana encontre que es redundante
	public boolean agregarNumeroTelefono(String str) {
		if (!lineas.contains(str)) {
			lineas.add(str);
			return true;
		} else {
			return false;
		}
	}

	/*
	public String obtenerNumeroLibre() {
		String linea;
		switch (tipoGenerador) {
			case "ultimo":
				linea = lineas.last();
				lineas.remove(linea);
				return linea;
			case "primero":
				linea = lineas.first();
				lineas.remove(linea);
				return linea;
			case "random":
				linea = new ArrayList<String>(lineas)
						.get(new Random().nextInt(lineas.size()));
				lineas.remove(linea);
				return linea;
		}
		return null;
	}*/

	//CAMBIO: Lógica del método original movida a la clase GeneradorStrategy y sus implementaciones
	public String obtenerNumeroLibre() {
		return generador.generar((TreeSet<String>) lineas); // ! VER ESTO, castié lineas a TreeSet<String> para que funcione.
	}

	//CAMBIO: modificado el setter para que reciba un GeneradorStrategy
	public void setGenerador(GeneradorStrategy generador) {
		this.generador = generador;
	}
}
