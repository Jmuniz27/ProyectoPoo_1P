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
        Random r = new Random();
        boolean aleatorioBool = r.nextBoolean(); // genera un número aleatorio entre 1 y arg-1
        
        
        boolean conti = true;
        
        //Añadir jugadores
        System.out.print("Ingrese nombre Jugador 0>> ");
        String j = sc.next();
        juego.agregarJugador(j);
        System.out.print("Ingrese nombre Jugador 1>> ");
        String j2 = sc.next();
        juego.agregarJugador(j2);
        
            
        do{
            if (j2.toLowerCase().equals("bot")){
                conti = juego.userBehavior();
                
                
            }
            else{
                
            }
        }while (juego.getJugadores().get(0).getMano().size()!=0 || juego.getJugadores().get(1).getMano().size()!=0 || conti);

        if (juego.getJugadores().get(0).getMano().size()== 0){
            System.out.println("Felicidades jugador 1, has ganado");
        }
        else if (juego.getJugadores().get(1).getMano().size()==0){
            System.out.println("Felicidades jugador 2, has ganado");
        }
        else{
            for (Ficha fich : juego.getJugadores().get(0).getMano()){
                if (fich.getLado1() == juego.ObtenerValorFinLinea() || fich.getLado2() == juego.obtenerValorInicioLinea()){
                    System.out.println("Ha ganado el jugador 1");
                    break;
                }
            }
            for (Ficha fich : juego.getJugadores().get(1).getMano()){
                if (fich.getLado1() == juego.ObtenerValorFinLinea() || fich.getLado2() == juego.obtenerValorInicioLinea()){
                    System.out.println("Ha ganado el jugador 2");
                    break;
                }
            }
        }
    }
}

