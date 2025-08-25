package pe.edu.upeu.encapsulamiento;

public class ClaseGeneral {

    public static void probarJugador() {
        Jugador jugador = new Jugador();
        jugador.setNombre("Messi");
        jugador.setApellido("Argentino");
        jugador.setEdad(25);
        jugador.setPosision("Delantero");
        jugador.setNumeroCam(15);

        jugador.toString();
    }

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

        probarJugador();
        /*ClaseGeneral cg = new ClaseGeneral();
        cg.probar();*/
    }

}
