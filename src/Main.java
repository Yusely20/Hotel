import capanegocio.CargoEmpleado;
import capanegocio.Cliente;
import capanegocio.Empleado;
import capanegocio.Hotel;

import java.rmi.server.ExportException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Hotel h = new Hotel();
        Scanner sc = new Scanner(System.in);
        int op;
        String cedula;
        Cliente clienteEncontrado,modificarCliente;
        do{
            op = menu();
            switch (op){
                case 1:
                    System.out.println("Ingrese la cedula del cliente");
                    cedula = sc.next();
                    if(datosCliente(h,cedula) != null)
                        System.out.println(h.agregarCliente(datos(cedula)));
                    else
                        System.out.println("El cliente ya existe");
                    break;
                case 2:
                    System.out.println("Ingrese la cedula del cliente");
                    cedula = sc.next();
                    if(h.buscarCliente(cedula) != null)
                        ordenarClientes(h.buscarCliente(cedula),null, new StringBuilder("Datos del cliente:\n\n"));
                    else
                        System.out.println("No existen clientes");
                    break;
                case 3:
                    System.out.println("Ingrese la cedula del cliente");
                    cedula = sc.next();
                    clienteEncontrado = datosCliente(h,cedula);
                    if(clienteEncontrado != null){
                        modificarCliente = datos(cedula);
                        System.out.println(h.modificarCliente(modificarCliente.getNombre(),modificarCliente.getApellido(),clienteEncontrado));
                    }
                    break;
                case 4:
                    System.out.println("Ingrese la cedula del cliente");
                    cedula = sc.next();
                    clienteEncontrado = datosCliente(h,cedula);
                    if(clienteEncontrado != null){
                        System.out.println(h.eliminarCliente(cedula));
                    }
                    break;
                case 5:
                    try{
                        List<Cliente> clientes = h.visualizarClientes();
                        ordenarClientes(null, clientes , new StringBuilder("Datos de los clientes:\n\n"));
                    }catch (Exception e){
                        System.out.println("No existe ningun cliente");
                    }
                    break;
            }

        }while (op != 6);
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        String menu =
                "1. Agregar Cliente\n" +
                "2. Buscar Cliente\n" +
                "3. Modificar Cliente\n"+
                "4. Eliminar Cliente\n"+
                        "5. Visualizar Clientes\n"+
                "Ingrese una opcion: ";
        System.out.print(menu);
        return sc.nextInt();
    }

    public static void ordenarClientes(Cliente cliente, List<Cliente> clients, StringBuilder stringB){
        if(clients != null){
            for(Cliente clientes: clients) {
                stringB.append("Cedula: ").append(clientes.getCedula()).append("\n").append("Nombre: ").append(clientes.getNombre()).append("\n").append("Apellido: ").append(clientes.getApellido()).append("\n");
            }
        } else {
            stringB.append("Cedula: ").append(cliente.getCedula()).append("\n").append("Nombre: ").append(cliente.getNombre()).append("\n").append("Apellido: ").append(cliente.getApellido()).append("\n");
        }
        System.out.println(stringB);
    }

    public static Cliente datosCliente(Hotel h, String cedula){
        Cliente clienteEncontrado = h.buscarCliente(cedula);
        if( clienteEncontrado != null){
            return clienteEncontrado;
        }
        else {
            System.out.println("no se encontro el cliente");
            return null;
        }
    }

    public static Cliente datos(String cedula){
        Scanner sc = new Scanner(System.in);
        String nombre,apellido;
        CargoEmpleado cargo;
        System.out.println("Ingrese el nombre del empleado");
        nombre = sc.next();
        System.out.println("Ingrese el apellido del empleado");
        apellido = sc.next();
        return new Cliente(cedula,nombre,apellido);
    }

}
