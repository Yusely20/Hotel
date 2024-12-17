
package capanegocio;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Articulo {

    private String nombre;
    private Categoria categoria;
    private int cantidadDisponible;
    private capanegocio.TipoAlerta prioridad;
    private List<Articulo> articulos ;
    public static final int LIMITEBAJO = 10;
    public static final int LIMITEMEDIO = 20;
    public static final int LIMITEALTO = 35;

    public Articulo (){
        articulos = new ArrayList<Articulo>();
        articulos.add(new Articulo("Escoba",Categoria.LIMPIEZA,100,TipoAlerta.NA));
        articulos.add(new Articulo("Trapeador",Categoria.LIMPIEZA,32,TipoAlerta.BAJA));
        articulos.add(new Articulo("Almohadas",Categoria.ROPA_CAMA,53,TipoAlerta.NA));
        articulos.add(new Articulo("Edredones",Categoria.ROPA_CAMA,12,TipoAlerta.MEDIA));
        articulos.add(new Articulo("Toallas",Categoria.ACCESORIO_BANIO,10,TipoAlerta.ALTA));
        articulos.add(new Articulo("Jabón",Categoria.ACCESORIO_BANIO,100,TipoAlerta.NA));
        articulos.add(new Articulo("Chicles",Categoria.ALIMENTO,7,TipoAlerta.ALTA));
        articulos.add(new Articulo("Dulces",Categoria.ALIMENTO,18,TipoAlerta.MEDIA));
    }

    public Articulo(String nombre, Categoria categoria, int cantidadDisponible, TipoAlerta prioridad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    
    public void setPrioridad(TipoAlerta prioridad) {
        this.prioridad = prioridad;
    }

    public StringBuilder mostrarArticulos(){
        StringBuilder sb = new StringBuilder("Articulos: \n");
        sb.append("Descripcion:      Categoria:       Canitdad: \n");
        sb.append("---------------------------------------------\n");
        for(Articulo articulo : articulos){
            sb.append(articulo.getNombre()+" "+articulo.getCategoria().toString()+" "+articulo.getCantidadDisponible()+"\n");
        }
        return sb;
    }

    public Articulo buscarArticulo(String nombre){
        for(Articulo articulo : articulos){
            if(articulo.getNombre().equals(nombre)){
                return articulo;
            }
        }
        return null;
    }

    public void agregarArticulo(String nombre, Categoria categoria, int cantidad, TipoAlerta prioridad) {
        if(buscarArticulo(nombre) == null){
            articulos.add(new Articulo(nombre, categoria, cantidad, prioridad));
        }
        else {
            JOptionPane.showMessageDialog(null,"El atciculo ya se encuetra registrado");
        }
    }

    public void eliminarArticulo(String nombre) {
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).getNombre().equals(nombre)) {
                JOptionPane.showMessageDialog(null,"Artículo eliminado: " + articulos.get(i).getNombre());
                articulos.remove(i);
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"Artículo no encontrado: " + nombre);
    }
    
    public void modificarArticulo(Articulo art, String nombre, Categoria categoria, TipoAlerta prioridad, int cantidad){
        try {
            art.setNombre(nombre);
            art.setCategoria(categoria);
            art.setPrioridad(prioridad);
            art.setCantidadDisponible(cantidad);
            JOptionPane.showMessageDialog(null, "Realizado");
            System.out.println(art.getNombre());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se encuentra el producto a modificar");
        }
    }

    public void retirarArticulo(String nombre, int cantidad){
        Articulo articulo = buscarArticulo(nombre);
        if(articulo != null) {
            if (cantidad > articulo.getCantidadDisponible()) {
                JOptionPane.showMessageDialog(null, "No hay suficientes articulos");
            } else {
                int cantidadTotal = articulo.getCantidadDisponible() - cantidad;
                alertas(cantidadTotal, articulo);
                articulo.setCantidadDisponible(cantidadTotal);
                JOptionPane.showMessageDialog(null, "Se realizo con exito");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No se encontro el articulo");
    }

    public void alertas(int cantidad, Articulo articulo){
        if(cantidad <= LIMITEBAJO){
            articulo.setPrioridad(TipoAlerta.ALTA);
            JOptionPane.showMessageDialog(null,"La prioridad de este articulo es: "+TipoAlerta.ALTA);
        } else if (cantidad > LIMITEBAJO && cantidad <= LIMITEMEDIO) {
            articulo.setPrioridad(TipoAlerta.MEDIA);
            JOptionPane.showMessageDialog(null,"La prioridad de este articulo es: "+TipoAlerta.MEDIA);
        } else if (cantidad > LIMITEMEDIO && cantidad < LIMITEALTO) {
            articulo.setPrioridad(TipoAlerta.BAJA);
            JOptionPane.showMessageDialog(null,"La prioridad de este articulo es: "+TipoAlerta.BAJA);
        }
        else {
            articulo.setPrioridad(TipoAlerta.NA);
            JOptionPane.showMessageDialog(null,"El articulo no tiene prioridad");
        }
    }
    
    public void comprarArticulo(String nombre, int cantidad){
        Articulo articulo = buscarArticulo(nombre);
        if(articulo != null){
            articulo.setCantidadDisponible(articulo.getCantidadDisponible()+cantidad);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se encontro el articulo");
        }
    }
    
}
