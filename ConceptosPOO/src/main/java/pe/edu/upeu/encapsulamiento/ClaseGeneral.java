package pe.edu.upeu.encapsulamiento;

public class ClaseGeneral {

    public static void probar() {
        Estudiante estudiante = new Estudiante();
        estudiante.setCarrera("Ing. Sistemas");
        estudiante.setCodigo("202510052");
        estudiante.trabajo();
    }

    public static void main(String[] args) {
        Persona persona = new Persona();

        persona.setNombre("wilson");
        persona.setEdad(23);
        persona.setGenero('M');
        persona.saludo();
        System.out.println("Genero: "+persona.getGenero());

        probar();

        /*ClaseGeneral cg = new ClaseGeneral();
        cg.probar();*/
    }

}
