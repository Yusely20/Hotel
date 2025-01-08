package capanegocio;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int numFactura;
    private String cedula;
    private Fecha fechaEmision;
    private double montoTotal;
    private boolean pagada;
    private MetodoPago metodoPago;

    private static List<Factura> historialFacturas = new ArrayList<>();

    public Factura(int numFactura, String cedula, Fecha fechaEmision, double montoTotal, MetodoPago metodoPago) {
        this.numFactura = numFactura;
        this.cedula = cedula;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.pagada = false;
        this.metodoPago = metodoPago;
        historialFacturas.add(this);
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
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

    public void setFechaEmision(Fecha fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
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

    public  void  pagar (){
        this.pagada = true;
    }

    public  List<Factura> buscarFactura(String cedula){
        List<Factura> facturaEncontrada = new ArrayList<>();
        return facturaEncontrada;
    }
    public  List<Factura> historialFacturas (){
        return new ArrayList<>(historialFacturas);
    }


}
