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
        Juego juego = new Juego();
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------\nBienvenido a Domino\n-------------------");
        System.out.println("MENÚ\n1. Multijugador\n2. Solo");
        System.out.println("Seleccione modo de juego(1 o 2): ");
        int modo = sc.nextInt();
        if(modo==1){
            System.out.print("Ingrese nombre Jugador 0>> ");
            String j = sc.next();
            juego.agregarJugador(j);
            System.out.print("Ingrese nombre Jugador 1>> ");
            String j2 = sc.next();
            juego.agregarJugador(j2);
            Jugador jugador0 = juego.getJugadores().get(0);
            Jugador jugador1 = juego.getJugadores().get(1);
            while(jugador0.jugabilidad(juego) && jugador1.jugabilidad(juego)){ //AMBOS jugadores deben de poder jugar para que el juego siga
                //JUGADOR0
                System.out.println("-------------------\nJugador 0\n-------------------");
                System.out.print("Jugador 0: Mano -> ");
                juego.getJugadores().get(0).imprimirMano();
                System.out.print("Linea de Juego -> ");
                juego.mostrarLinea();
                if(jugador0.jugabilidad(juego)){
                    System.out.print("Indice de ficha para jugar (0 es el primero): ");
                    int pos = sc.nextInt();
                    //el siguiente while valida que pos1 sea correcto
                    while(pos < 0 || pos >= juego.getJugadores().get(0).getMano().size()){ 
                        System.out.println("Movimiento invalido. Intente de nuevo (0 es el primero): ");
                        pos = sc.nextInt();
                    }
                    Ficha f = jugador0.getMano().get(pos);                
                    boolean a= juego.agregarFichaLinea(f,jugador0);//Intenta agregar la ficha
                    while(a==false){ //valida que se cumpla el boolean de aggficha
                        System.out.println("Movimiento invalido. Intente de nuevo (0 es el primero): ");
                        pos = sc.nextInt();
                        f = jugador0.getMano().get(pos);                
                        juego.agregarFichaLinea(f,jugador0);
                        a = juego.agregarFichaLinea(f,jugador0);
                    }
                    System.out.print("Nueva línea de juego -> ");
                    juego.mostrarLinea();
                }else {
                    System.out.println("Perdiste");
                    break;
                }
                
                
                //JUGADOR1
                System.out.println("-------------------\nJugador 1\n-------------------");
                System.out.println("Jugador 1: Mano -> ");
                juego.getJugadores().get(1).imprimirMano();
                System.out.println("Linea de Juego -> ");
                juego.mostrarLinea();
                if(jugador1.jugabilidad(juego)){
                System.out.println("Indice de ficha para jugar (0 es el primero): ");
                int pos2 = sc.nextInt();
                //el siguiente while valida que pos2 sea correcto
                while(pos2 < 0 || pos2 >= juego.getJugadores().get(1).getMano().size()){
                    System.out.println("Movimiento invalido. Intente de nuevo (0 es el primero): ");
                    pos2 = sc.nextInt();
                }
                Ficha f1 = jugador1.getMano().get(pos2);                
                boolean b = juego.agregarFichaLinea(f1,jugador1); //Intenta agregar la ficha
                while(b==false){ //valida que se cumpla el boolean de aggficha
                    System.out.println("Movimiento invalido. Intente de nuevo (0 es el primero): ");
                    pos2 = sc.nextInt();
                    f1 = jugador1.getMano().get(pos2);                
                    juego.agregarFichaLinea(f1,jugador1);
                    b = juego.agregarFichaLinea(f1,jugador1);
                }
                System.out.print("Nueva línea de juego -> ");
                juego.mostrarLinea();
                }else{
                    System.out.println("Perdiste");
                    break;
                }
            }
            
        }
    }
}

