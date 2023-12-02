/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyectopoo1p;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jmuni
 */
public class ProyectoPOO1P {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Juego juego = new Juego();
        //Añadir jugadores
        System.out.println("Ingrese nombre Jugador>> ");
        String j = sc.next();
        juego.agregarJugador(j);
        juego.agregarJugador("bot");
        
        //se escoge la persona J
        System.out.println("El jugador que va a iniciar el juego es el Jugador: "+ j);
        Jugador juga = juego.getJugadores().get(0);
        Jugador bot = juego.getJugadores().get(1);
        juego.mostrarLinea();
        for (int i = 0; i<juga.getMano().size(); i++){
            System.out.println("Jugador " + j + ":");
            juego.mostrarLinea();
            }
    }
}