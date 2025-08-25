package pe.edu.upeu.herencia;

import pe.edu.upeu.encapsulamiento.Jugador;

public class Carro extends Vehiculo {
    String modelo="Mustang";
    String placa="PE-14454";
    String color="Blanco";

    void caracteristica(){
        System.out.println("Las caracteristicas de este carro son: ");
        System.out.println("Marca: "+marca);
        System.out.println("Modelo: "+modelo);
        System.out.println("Modelo: "+color);
        System.out.println("Modelo: "+placa);
    }
    public static void main(String[] args) {
        Carro carro=new Carro();
        carro.caracteristica();
        carro.sonido();
    }
}
