package capanegocio;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{

    private List<Persona> clientes;

    public Cliente(String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
        this.clientes = new ArrayList<>();
    }

    public Cliente(){}

    public String registrarCliente(String cedula, String nombre, String apellido){
        return "";
    }

    public String modificarCliente(String cedula, String nombre, String apellido){
        return " ";
    }

    public String eliminarCliente(String cedula){
        return "";
    }

    public List<Persona> visualizarClientes(){
        return clientes;
    }

    public Persona buscarCliente(String cedula){
        return null;
    }
}
