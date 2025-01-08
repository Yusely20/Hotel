package capanegocio;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int numFactura;
    private String cedula;
    private Fecha fechaEmision;
    private double montoTotal;
    private boolean pagada;
    private String descripcion;
    private Habitacion habitacion;
    private MetodoPago metodoPago;
    private List<Factura> historialFacturas;

    public Factura(int numFactura, String cedula, Fecha fechaEmision, double montoTotal, String descripcion, MetodoPago metodoPago) {
        this.numFactura = numFactura;
        this.cedula = cedula;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.descripcion = descripcion;
        this.pagada = false;
        this.metodoPago = metodoPago;
        historialFacturas = new ArrayList<>();
    }

    public int getNumFactura() {
        return numFactura;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Fecha getFechaEmision() {
        return fechaEmision;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void pagar(){
        this.pagada = true;
    }

    public List<Factura> getHistorialFacturas() {
        return historialFacturas;
    }

    public Factura buscarFactura(String cedula){
        for(Factura factura: historialFacturas){
            if(factura.cedula.equals(cedula)){
                return factura;
            }
        }
        return null;
    }

    public String agregarFactura(){
        historialFacturas.add(new Factura(243,"",new Fecha(1,3,2004),67.9,"",MetodoPago.TARJETA_DEBITO));
        return "";
    }

}
