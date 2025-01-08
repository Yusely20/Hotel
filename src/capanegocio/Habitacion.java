package capanegocio;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Habitacion {

    private int numHabitacion;
    private TipoHabitacion tipoHabitacion;
    private int[] dias = new int[30];
    private double precioNoche;
    private List<Habitacion> habitaciones;

    public Habitacion(int numHabitacion, double precioNoche, TipoHabitacion tipoHabitacion) {
        this.numHabitacion = numHabitacion;
        this.precioNoche = precioNoche;
        this.tipoHabitacion = tipoHabitacion;
        for (int i = 1; i < 31; i++) {
            dias[i-1]=i;
        }
        habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion(1,13.32,TipoHabitacion.INDIVIDUAL));
        habitaciones.add(new Habitacion(2,22,TipoHabitacion.DOBLE));
        habitaciones.add(new Habitacion(3,32,TipoHabitacion.SUITE));
        habitaciones.add(new Habitacion(4,11.2,TipoHabitacion.INDIVIDUAL));
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int[] getDias() {
        return dias;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public Habitacion buscarHabitacion(int numHabitacion){
        for(Habitacion habitacion: habitaciones){
            if(numHabitacion == habitacion.numHabitacion){
                return habitacion;
            }
        }
        return null;
    }
}
