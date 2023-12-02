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
        System.out.println("-------------------\nBienvenido a Domino\n-------------------");
        System.out.println("Modo de Juego: ");
        Scanner sc = new Scanner(System.in);
        Juego juego = new Juego();
        System.out.print("Ingrese nombre Jugador 1>> ");
        String j = sc.next();
        juego.agregarJugador(j);
        System.out.println("");
        boolean conti = true;
    }
}
