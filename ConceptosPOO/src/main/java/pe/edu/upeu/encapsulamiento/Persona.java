package pe.edu.upeu.encapsulamiento;

public class Persona {
    String nombre;
    int edad;
    char genero;

    public void saludo(){
        System.out.println("Hola , mi nombre es "+nombre+" y mi edad es "+edad);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
