import java.util.*;

public class Empleado {
    private String nombre;
    private String apellido;
    private int numeroEmpleado;
    private List<Integer> calificaciones;

    public Empleado(String nombre, String apellido, int numeroEmpleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroEmpleado = numeroEmpleado;
        this.calificaciones = new ArrayList<>();
    }
    
    // Agregar métodos para acceder y manipular las calificaciones
    public void agregarCalificacion(int calificacion) {
        // Verificar que la calificación esté en el rango [1, 10]
        if (calificacion >= 1 && calificacion <= 10) {
            calificaciones.add(calificacion);
        } else {
            System.out.println("La calificación debe estar entre 1 y 10.");
        }
    }

    // Agregar un método para calcular el promedio de las calificaciones
    public double calcularPromedioCalificaciones() {
        int sum = 0;
        for (int calificacion : calificaciones) {
            sum += calificacion;
        }
        return (double) sum / calificaciones.size();
    }
    
    // Método para obtener el nombre del empleado
    public String getNombre() {
        return nombre;
    }

    // Método para obtener el número de empleado
    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    // Método para obtener las calificaciones del empleado
    public List<Integer> getCalificaciones() {
        return calificaciones;
    }

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
