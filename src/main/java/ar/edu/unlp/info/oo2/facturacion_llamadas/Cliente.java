package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public List<Llamada> llamadas;
	private String nombre;
	private String numeroTelefono;

	public Cliente(String nombre, String numeroTelefono) {
		this.llamadas = new ArrayList<Llamada>();
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
	}

	public String getNombre() {
		return nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}

}
