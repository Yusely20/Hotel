import capanegocio.CargoEmpleado;
import capanegocio.Empleado;
import capanegocio.Hotel;

import java.util.List;
import java.util.Scanner;

public class MainAsignacionTarea {
    public static void main(String[] args) throws Exception {
        Hotel h = new Hotel();
        Scanner sc = new Scanner(System.in);
        int op;
        String cedula;
        Empleado empleadoEncontrado, empleado;
        do{
            op = menu();
            switch (op){
                case 1:
                    System.out.println("Ingrese la cedula del empleado");
                    cedula = sc.next();
                    if(datosEmpleado(h,cedula)==null){
                        System.out.println(h.agregarEmpleado(datos(cedula)));
                    }
                    else {System.out.println("El empleado ya existe");}
                    break;
                case 2:
                    System.out.println("Ingrese la cedula del empleado");
                    cedula = sc.next();
                    if(h.buscarEmpleado(cedula) != null)
                        ordenarEmpleados(h.buscarEmpleado(cedula),null, new StringBuilder("Datos del empleado:\n\n"));
                    else
                        System.out.println("No hay empleados");
                    break;
                case 3:
                    System.out.println("Ingrese la cedula del empleado");
                    cedula = sc.next();
                    empleadoEncontrado = datosEmpleado(h,cedula);
                    if(empleadoEncontrado != null){
                        empleado = datos(cedula);
                        System.out.println(h.modificarEmpleado(empleado.getNombre(),empleado.getApellido(),empleado.getCargo(),empleadoEncontrado));
                    }else{System.out.println("no se encontro el empleado");}
                    break;
                case 4:
                    System.out.println("Ingrese la cedula del empleado");
                    cedula = sc.next();
                    empleadoEncontrado = datosEmpleado(h,cedula);
                    if(empleadoEncontrado != null){
                        System.out.println(h.eliminarEmpleado(cedula));
                    }else{System.out.println("no se encontro el empleado");}
                    break;
                case 5:
                    try{
                        List<Empleado> empleados = h.visualizarEmpleado();
                        ordenarEmpleados(null, empleados , new StringBuilder("Datos de los empleados:\n\n"));
                    }catch (Exception e){
                        System.out.println("No existe ningun empleado");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese la cedula del empleado");
                    cedula = sc.next();
                    empleado =  datosEmpleado(h,cedula);
                    if(empleado != null){
                        h.visualizarAsignaciones(empleado);
                        System.out.print("Ingrese la opcion: ");
                        int opcion = sc.nextInt();
                        h.asignarTarea(opcion,empleado);
                    }
                    else
                        System.out.println("No se encontro el empleado");
//                case 7:
//                    System.out.println("Ingrese la cedula del empleado");
//                    cedula = sc.next();
//                    empleado =  datosEmpleado(h,cedula);
//                    if(empleado != null){
//                        h.modificarTarea();
//                    }
//                    else
//                        System.out.println("No se encontro el empleado");
            }

        }while (op != 8);
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        String menu =
                        "1. Agregar Empleado\n" +
                        "2. Buscar Empleado\n" +
                        "3. Modificar Empleado\n"+
                        "4. Eliminar Empleado\n"+
                        "5. Visualizar Empleado\n"+
                        "6. Asignar Tarea\n"+
                                "7. Modificar Tarea de empleado\n"+
                        "Ingrese una opcion: ";
        System.out.print(menu);
        return sc.nextInt();
    }

    public static Empleado datos(String cedula){
        Scanner sc = new Scanner(System.in);
        String nombre,apellido;
        int intcargo;
        CargoEmpleado cargo;
        System.out.println("Ingrese el nombre del empleado");
        nombre = sc.next();
        System.out.println("Ingrese el apellido del empleado");
        apellido = sc.next();
        System.out.println("""
                    1. Conserje
                2. Recepcion
                Ingrese el cargo del empleado:
                """);
        intcargo = sc.nextInt();
        cargo = switch (intcargo){
            case 1 -> CargoEmpleado.CONSERJE;
            case 2 -> CargoEmpleado.RECEPCION;
            default -> CargoEmpleado.CONSERJE;};
        return new Empleado(cedula,nombre,apellido,cargo);
    }

    public static void ordenarEmpleados(Empleado empleado, List<Empleado> empleados, StringBuilder stringB){
        if(empleados != null){
            for(Empleado empleado1: empleados) {
                stringB.append("Cedula: ").append(empleado1.getCedula()).append("\n").append("Nombre: ").append(empleado1.getNombre()).append("\n").append("Apellido: ").append(empleado1.getApellido()).append("\n").append("Cargo: ").append(empleado1.getCargo().toString()).append("\n");
            }
        } else {
            stringB.append("Cedula: ").append(empleado.getCedula()).append("\n").append("Nombre: ").append(empleado.getNombre()).append("\n").append("Apellido: ").append(empleado.getApellido()).append("\n").append("Cargo: ").append(empleado.getCargo().toString()).append("\n");
        }
        System.out.println(stringB);
    }

    public static Empleado datosEmpleado(Hotel h, String cedula){
        Empleado empleadoEncontrado = h.buscarEmpleado(cedula);
        return empleadoEncontrado;
    }
}
