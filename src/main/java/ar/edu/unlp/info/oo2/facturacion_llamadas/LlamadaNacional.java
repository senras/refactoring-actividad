package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaNacional extends Llamada{

    public LlamadaNacional(String origen, String destino, int duracion) {
            super(origen, destino, duracion);
    }

    //NUEVO
    public double calcularCosto() {
        return 3 * this.getDuracion() + (3 * this.getDuracion() * 0.21);
    }

}
