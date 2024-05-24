package ar.edu.unlp.info.oo2.facturacion_llamadas;

//Quité tipo de llamada, la volví clase abstracta para que el método calcularCosto sea abstracto y lo implementen las clases hijas.

public abstract class Llamada {
	private String origen;
	private String destino;
	private int duracion;

	public Llamada(String origen, String destino, int duracion) {
		this.origen= origen;
		this.destino= destino;
		this.duracion = duracion;
	}

	public String getRemitente() {
		return destino;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public String getOrigen() {
		return origen;
	}

	//NUEVO: pensar nombre
	public abstract double calcularCosto();
}


/*
Quitar getters no utilizados?
*/
