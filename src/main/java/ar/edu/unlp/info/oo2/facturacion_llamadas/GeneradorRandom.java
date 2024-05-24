package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class GeneradorRandom implements GeneradorStrategy{

    public String generar(TreeSet<String> lineas){
        String linea = new ArrayList<String>(lineas)
                .get(new Random().nextInt(lineas.size()));
        lineas.remove(linea);
        return linea;
    }
}
