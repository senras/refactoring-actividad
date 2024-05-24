package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;
import java.util.TreeSet;

public interface GeneradorStrategy {

    public String generar(TreeSet<String> lineas);
}
