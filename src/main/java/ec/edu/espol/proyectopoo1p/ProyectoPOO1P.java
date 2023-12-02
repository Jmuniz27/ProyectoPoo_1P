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
        
        boolean conti = true;
        do{
            //Añadir jugadores
            System.out.print("Ingrese nombre Jugador 1>> ");
            String j = sc.next();
            juego.agregarJugador(j);
            System.out.print("Ingrese nombre Jugador 2>> ");
            String j2 = sc.next();
            juego.agregarJugador(j2);
            

            if (j2.toLowerCase().equals("bot")){
                System.out.print("Jugador 0 -> ");
                juego.getJugadores().get(0).imprimirMano();
                System.out.println("Linea de Juego -> ");
                juego.mostrarLinea();
                System.out.print("Índice de ficha para jugar (0 es el primero): ");
                int indice = sc.nextInt();
                while (indice < 0 || indice >= juego.getJugadores().get(0).getMano().size()){
                    System.out.print("Índice inválido, ingrese una posición correcta: ");
                    indice = sc.nextInt();
                }

                conti = true;
                if (juego.agregarFichaLinea(juego.getJugadores().get(0).getMano().get(indice), juego.getJugadores().get(0))){
                    System.out.println("Movimiento Válido.");
                    juego.mostrarLinea();
                }
                else{

                    for (Ficha fich : juego.getJugadores().get(0).getMano()){
                        if (fich.getLado1() == juego.ObtenerValorFinLinea() || fich.getLado2() == juego.obtenerValorInicioLinea()){

                            conti = true;
                            System.out.println("Ficha tenía "+ juego.getJugadores().get(0).getMano().get(indice) + " No puedo jugar esa ficha, inténtalo de nuevo");
                            break;
                        }
                        else
                            conti = false;
                    }
                }

                while (conti == true ){
                    indice = sc.nextInt();
                    while (indice < 0 || indice >= juego.getJugadores().get(0).getMano().size()){
                        System.out.print("Índice inválido, ingrese una posición correcta: ");
                        indice = sc.nextInt();
                    }

                    conti = true;
                    if (juego.agregarFichaLinea(juego.getJugadores().get(0).getMano().get(indice), juego.getJugadores().get(0))){
                        System.out.println("Movimiento Válido.");
                        juego.mostrarLinea();
                    }
                    else{
                        for (Ficha fich : juego.getJugadores().get(0).getMano()){
                            if (fich.getLado1() == juego.ObtenerValorFinLinea() || fich.getLado2() == juego.obtenerValorInicioLinea()){
                                conti = true;
                                break;
                            }
                            else
                                conti = false;
                        }
                    }
                }

                for (int i = 0 ; i < juego.getJugadores().size() ; i++){
                    if (juego.agregarFichaLinea(juego.getJugadores().get(1).getMano().get(i), juego.getJugadores().get(1))){
                        System.out.println("Movimiento Válido.");
                        juego.mostrarLinea();
                    }
                }
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