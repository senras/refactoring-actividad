package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

//DUDA general: Quitar getters y setters no utilizados?

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles();

	//DUDA: ponerlas como constantes en las clases ClienteFisico y ClienteJuridico?
	static double descuentoJur = 0.15;
	static double descuentoFis = 0;


	//CAMBIO: Lógica del método original movida a la clase GestorNumerosDisponibles
	public boolean agregarNumeroTelefono(String str) {
		return guia.agregarNumeroTelefono(str);
	}

	public String obtenerNumeroLibre() {
		return guia.obtenerNumeroLibre();
	}

	/*public Cliente registrarUsuario(String data, String nombre, String tipo) {
		Cliente var = new Cliente();
		if (tipo.equals("fisica")) {
			var.setNombre(nombre);
			String tel = this.obtenerNumeroLibre();
			var.setTipo(tipo);
			var.setNumeroTelefono(tel);
			var.setDNI(data);
		}
		else if (tipo.equals("juridica")) {
			String tel = this.obtenerNumeroLibre();
			var.setNombre(nombre);
			var.setTipo(tipo);
			var.setNumeroTelefono(tel);
			var.setCuit(data);
		}
		clientes.add(var);
		return var;
	}*/

	//CAMBIO: Reemplazan registroUsuario
	public Cliente registrarUsuarioFisico(String dni, String nombre) {
		ClienteFisico cliente = new ClienteFisico(nombre, this.obtenerNumeroLibre(), dni);
		clientes.add(cliente);
		return cliente;
	}

	public Cliente registrarUsuarioJuridico(String cuit, String nombre) {
		ClienteJuridico cliente = new ClienteJuridico(nombre, this.obtenerNumeroLibre(), cuit);
		clientes.add(cliente);
		return cliente;
	}

/*	public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.llamadas.add(llamada);
		return llamada;
	}*/

	//CAMBIO: Reemplazan registroLlamada
	public Llamada registrarLlamadaInternacional(Cliente origen, Cliente destino, int duracion) {
		LlamadaInternacional llamada = new LlamadaInternacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.llamadas.add(llamada);
		return llamada;
	}

	public Llamada registrarLlamadaNacional(Cliente origen, Cliente destino, int duracion) {
		LlamadaNacional llamada = new LlamadaNacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.llamadas.add(llamada);
		return llamada;
	}

	//CAMBIO: Se cambian las llamadas a los métodos como se usa polimorfismo
	//DUDA: Poner el calculo de descuento en cliente?
	public double calcularMontoTotalLlamadas(Cliente cliente) {
		double c = 0;
		for (Llamada l : cliente.llamadas) {
			double auxc = l.calcularCosto();
			if (cliente instanceof ClienteFisico) {
				auxc -= auxc*descuentoFis;
			} else if(cliente instanceof ClienteJuridico) {
				auxc -= auxc*descuentoJur;
			}
			c += auxc;
		}
		return c;
	}

	public int cantidadDeUsuarios() {
		return clientes.size();
	}

	public boolean existeUsuario(Cliente persona) {
		return clientes.contains(persona);
	}

	public GestorNumerosDisponibles getGestorNumeros() {
		return this.guia;
	}
}
