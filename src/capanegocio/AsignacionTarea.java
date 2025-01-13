package capanegocio;

public class AsignacionTarea {
    private EstadoAsignacion estado;
    private String asignacion;

    public AsignacionTarea( EstadoAsignacion estado, String asignacion) {
        this.estado = estado;
        this.asignacion = asignacion;
    }

    public EstadoAsignacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsignacion estado) {
        this.estado = estado;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public AsignacionTarea asignar(CargoEmpleado cargo){

     if(CargoEmpleado.CONSERJE == cargo){

     }else {

     }
     return new AsignacionTarea(EstadoAsignacion.PENDIENTE," ");
    }
}
