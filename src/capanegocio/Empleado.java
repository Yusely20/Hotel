package capanegocio;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona {
    private CargoEmpleado cargo;
    private boolean disponibilidad;
    private List<String> asiganciones;

    public Empleado(String cedula, String nombre, String apellido, CargoEmpleado cargo, Boolean disponibilidad) {
        super(cedula, nombre, apellido);
        this.cargo = cargo;
        this.disponibilidad = disponibilidad;
        this.asiganciones = new ArrayList<>();
    }

    public CargoEmpleado getCargo() {
        return cargo;
    }

    public void setCargo(CargoEmpleado cargo) {
        this.cargo = cargo;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String agregarEmpleado(String nombre, String apellido){
      return " ";
    }

    public String eliminarEmpleado(String cedula){
      return "";
    }

    public String modificarEmpleado(String cedula){
        return "";
    }

    public String dispoEmpleado (String cedula){
        return "";
    }

    public Empleado buscarEmpleado (String cedula){
        return new Empleado("","","",CargoEmpleado.CONSERJE,true);
    }

    public String asignarTarea(String cedula){
        AsignacionTarea at = new AsignacionTarea();
        at.asignar(CargoEmpleado.CONSERJE);
        asiganciones.add("");
        return "Se asigno sdasbasb";
    }

    public List<String> mostrarTareas(){
        return asiganciones;
    }
}
