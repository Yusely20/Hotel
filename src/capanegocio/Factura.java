package capanegocio;

import java.util.Date;

public class Factura {
    private int numFactura;
    private Cliente cliente;
    private Date fechaEmision;
    private double montoTotal;
    private boolean pagada;
    private String descripcion;
    private Reserva reserva;
    private MetodoPago metodoPago;


    public Factura(int numFactura, Cliente cliente, Date fechaEmision, double montoTotal, String descripcion, Reserva reserva, MetodoPago metodoPago) {
        this.numFactura = numFactura;
        this.cliente = cliente;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.descripcion = descripcion;
        this.pagada = false;
        this.reserva = reserva;
        this.metodoPago = metodoPago;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void marcarComoPagada() {
        this.pagada = true;
    }
}
