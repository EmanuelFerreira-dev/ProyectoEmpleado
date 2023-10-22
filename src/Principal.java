import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private List<Empleado> empleados = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("Menú Principal");
            System.out.println("1) Ingresar nuevo empleado");
            System.out.println("2) Buscar empleado por nombre o por número de empleado");
            System.out.println("3) Mostrar listado completo");
            System.out.println("4) Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de leer un número

            switch (opcion) {
                case 1:
                    ingresarNuevoEmpleado();
                    break;
                case 2:
                	buscarEmpleado();
                	break;
                case 3:
                    mostrarListadoEmpleados();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public void ingresarNuevoEmpleado() {
        System.out.println("Ingresar nuevo empleado:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Número de Empleado: ");
        int numeroEmpleado = scanner.nextInt();
        scanner.nextLine();

        Empleado empleado = new Empleado(nombre, apellido, numeroEmpleado);

        System.out.print("Calificación Q1: ");
        int calificacionQ1 = scanner.nextInt();
        scanner.nextLine();
        empleado.agregarCalificacion(calificacionQ1);

        System.out.print("Calificación Q2: ");
        int calificacionQ2 = scanner.nextInt();
        scanner.nextLine();
        empleado.agregarCalificacion(calificacionQ2);

        System.out.print("Calificación Q3: ");
        int calificacionQ3 = scanner.nextInt();
        scanner.nextLine();
        empleado.agregarCalificacion(calificacionQ3);

        empleados.add(empleado);

        System.out.println("Empleado registrado con éxito.");

        // Submenú para agregar otro empleado o volver al menú principal
        while (true) {
            System.out.println("1) Agregar otro empleado");
            System.out.println("2) Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int subOpcion = scanner.nextInt();
            scanner.nextLine();

            if (subOpcion == 1) {
                ingresarNuevoEmpleado();
            } else if (subOpcion == 2) {
                return;
            } else {
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public void mostrarListadoEmpleados() {
        System.out.println("Listado de Empleados:");
        for (Empleado empleado : empleados) {
            System.out.println("Nombre: " + empleado.getNombre() + " " + empleado.getApellido());
            System.out.println("Número de Empleado: " + empleado.getNumeroEmpleado());
            System.out.println("Calificaciones: " + empleado.getCalificaciones());
            System.out.println();
        }
    }
    
    public void buscarEmpleado() {
        System.out.println("Buscar empleado:");
        System.out.println("1) Buscar por nombre");
        System.out.println("2) Buscar por número de empleado");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Ingrese el nombre del empleado: ");
            String nombreBusqueda = scanner.nextLine();
            buscarPorNombre(nombreBusqueda);
        } else if (opcion == 2) {
            System.out.print("Ingrese el número de empleado: ");
            int numeroEmpleadoBusqueda = scanner.nextInt();
            buscarPorNumeroEmpleado(numeroEmpleadoBusqueda);
        } else {
            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    public void buscarPorNombre(String nombreBusqueda) {
        boolean encontrado = false;
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                mostrarInformacionEmpleado(empleado);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void buscarPorNumeroEmpleado(int numeroEmpleadoBusqueda) {
        boolean encontrado = false;
        for (Empleado empleado : empleados) {
            if (empleado.getNumeroEmpleado() == numeroEmpleadoBusqueda) {
                mostrarInformacionEmpleado(empleado);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void mostrarInformacionEmpleado(Empleado empleado) {
        System.out.println("Nombre: " + empleado.getNombre() + " " + empleado.getApellido());
        System.out.println("Número de Empleado: " + empleado.getNumeroEmpleado());
        System.out.println("Calificaciones: " + empleado.getCalificaciones());
        System.out.println();
    }
    
    

    public static void main(String[] args) {
        Principal sistema = new Principal();
        sistema.mostrarMenuPrincipal();
    }
}

