package pe.edu.upeu.encapsulamiento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private String posision;
    private int numeroCam;

    @Override
    public String toString() {
        return "El jugador tiene estas caracteristicas:\n"+"nombre:"+nombre+"\n"+"Apellido:"+apellido+"\n"+"Edad:"+edad+"\n"+"Posicion:"+posision+"\n"+"Camiseta:"+numeroCam+"\n";
    }
}
