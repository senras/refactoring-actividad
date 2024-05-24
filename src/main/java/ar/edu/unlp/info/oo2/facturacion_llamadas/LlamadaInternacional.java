package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaInternacional extends Llamada{

    public LlamadaInternacional(String origen, String destino, int duracion) {
            super(origen, destino, duracion);
    }

    //NUEVO
    public double calcularCosto() {
        return 150 * this.getDuracion() + (150 * this.getDuracion() * 0.21) + 50;
    }
}
