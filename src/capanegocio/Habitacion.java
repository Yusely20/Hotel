package capanegocio;

import java.util.ArrayList;

public class Habitacion {

    private int numHabitacion;
    private TipoHabitacion tipoHabitacion;
    private int[] dias = new int[30];
    private double precioNoche;

    Habitacion(){
        for (int i = 1; i < 31; i++) {
            dias[i-1]=i;
        }
    }

}
