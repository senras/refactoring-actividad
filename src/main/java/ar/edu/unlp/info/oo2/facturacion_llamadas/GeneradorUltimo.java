package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;

public class GeneradorUltimo implements GeneradorStrategy{

    @Override
    public String generar(TreeSet<String> lineas){
        String linea = lineas.last();
        lineas.remove(linea);
        return linea;
    }
}
