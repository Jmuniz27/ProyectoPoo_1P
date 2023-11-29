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
        System.out.println("Ingrese nombre Jugador 0>> ");
        String j0 = sc.next();
        System.out.println("Ingrese nombre Jugador 1>> ");
        String j1 = sc.next();
        juego.agregarJugador(j0);
        juego.agregarJugador(j1);
       
       //el jugador se escoge al azar
        Random rd = new Random();
        int primero = rd.nextInt(0,1);
        System.out.println("El jugador que va a iniciar el juego es el Jugador: "+ primero);
        Jugador juga = juego.getJugadores().get(primero);
        Ficha fSelec = null;
        
        
        while(juego.getJugadores().size()!=0 && fSelec == null){
            //recorrer las fichas del primer jugador
            for(Ficha f: juga.getMano()){
                if (juego.agregarFichaLinea(f, juga)) {
                    fSelec = f;
                    break;
                }
            }
        }
        if (fSelec == null) {
                juego.getJugadores().remove(juga);
                if (juego.getJugadores().size()!=0) {
                    juga = juego.getJugadores().get(0);
                }
            }
    }
}
