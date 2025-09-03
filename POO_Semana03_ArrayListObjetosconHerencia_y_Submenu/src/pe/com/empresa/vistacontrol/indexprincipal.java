/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.empresa.vistacontrol;

import pe.com.empresa.utils.Lectura;
import pe.com.empresa.utils.Utilitarios;

/**
 *
 * @author wilson
 */
public class indexprincipal {
    
    private static Lectura leer = new Lectura();
    public static void menu(){
        System.out.print("""
        *** MENU PRINCIPAL ***
        1. Trabajador
        2. Estudiante
        3. Salir
        """);

        System.out.print("Seleccione opcion [1-3]: ");
    }
    public static void inicio(){
        int opcion;
        indextrabajador.datosdeinstalacion();
        indexestudiante.datosdeinstalacion();
        do {
            menu();
            opcion = leer.entero();
            switch (opcion) {
                case 1 -> indextrabajador.inicio();
                case 2 -> indexestudiante.inicio();
                case 3 -> Utilitarios.salir();
                default -> Utilitarios.error(1);
            }
        } while (opcion!=3);
    }
}
