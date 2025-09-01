package pe.com.empresa.vistacontrol;
import pe.com.empresa.modelo.Persona;
/**
* @author Daniel Levano
*/
public class Index {
 public static void inicio(){
 Persona persona = new Persona("Wilson", 23, 1.67);

 // Mostrar los valores del Objeto
 System.out.println("DATOS INGRESADOS");
 System.out.println("* Nombre: " + persona.getNombre());
 System.out.println("* Edad: " + persona.getEdad());
 System.out.println("* Talla: " + persona.getTalla());
 }
 public static void main(String[] args) {
 inicio();
 }
} 