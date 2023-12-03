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
            do{ //AMBOS jugadores deben de poder jugar para que el juego siga
                //JUGADOR0 
                ProyectoPOO1P.jugadorJuego(jugador0, juego);
                
                //JUGADOR1
                ProyectoPOO1P.jugadorJuego(jugador1, juego);
                
                if(!jugador0.jugabilidad(juego) || !jugador1.jugabilidad(juego)){
                    if(!jugador0.jugabilidad(juego)){
                        ProyectoPOO1P.jugadorJuego(jugador1, juego);
                    }
                    else if(!jugador1.jugabilidad(juego)){
                        ProyectoPOO1P.jugadorJuego(jugador0, juego);
                    }
                }
                }while(jugador0.jugabilidad(juego) && jugador1.jugabilidad(juego));
            if(jugador0.jugabilidad(juego)==false){
                if(jugador0.getMano().size()==0)
                    System.out.println("El jugador "+jugador0.getNombre()+" gana ya que jugó sus fichas. El "+jugador1.getNombre()+ " pierde.");
                else
                    System.out.println("El jugador "+jugador0.getNombre()+" ya no puede jugar fichas. El "+jugador1.getNombre()+ " gana.");
            }
            else{
                if(jugador1.getMano().size()==0)
                    System.out.println("El jugador "+jugador1.getNombre()+" gana ya que jugó sus fichas. El "+jugador0.getNombre()+ " pierde.");
                else
                    System.out.println("El jugador "+jugador1.getNombre()+" ya no puede jugar fichas. El "+jugador0.getNombre()+ " gana.");               
            }
            }
        
        //pelea contra maquina
        else if(modo == 2){
            //ingresa el usuario
            System.out.print("Ingrese su nombre>> ");
            String solo = sc.next();
            juego.agregarJugador(solo);
            
            //se crea al bot
            juego.agregarJugador("bot");
            
            //jugadores
            Jugador jugador = juego.getJugadores().get(0);
            Jugador bot = juego.getJugadores().get(1);
            Random rd = new Random();
            boolean primero = rd.nextBoolean();
            while(jugador.jugabilidad(juego) && bot.jugabilidad(juego)){
                if(primero){
                    ProyectoPOO1P.jugadorJuego(jugador, juego);
                    ProyectoPOO1P.botJuego(bot, juego);
                }
                else{
                    ProyectoPOO1P.botJuego(bot, juego);
                    ProyectoPOO1P.jugadorJuego(jugador, juego);                    
                }
            }
            if(jugador.jugabilidad(juego)==false){
                if(jugador.getMano().size()==0)
                    System.out.println("El jugador "+jugador.getNombre()+" gana ya que jugó sus fichas. El "+bot.getNombre()+ " pierde.");
                else
                    System.out.println("El jugador "+jugador.getNombre()+" ya no puede jugar fichas. El "+bot.getNombre()+ " gana.");
            }
            else{
                if(bot.getMano().size()==0)
                    System.out.println("El jugador "+bot.getNombre()+" gana ya que jugó sus fichas. El "+jugador.getNombre()+ " pierde.");
                else
                    System.out.println("El jugador "+bot.getNombre()+" ya no puede jugar fichas. El "+jugador.getNombre()+ " gana.");               
            }
        }
    }
    public static void jugadorJuego(Jugador jugador, Juego juego){
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------\nJugador " + jugador.getNombre() +"\n-------------------");
        System.out.print("Jugador " + jugador.getNombre() +": Mano -> ");
        jugador.imprimirMano();
        System.out.println("Linea de Juego -> ");
        juego.mostrarLinea();

        System.out.print("Indice de ficha para jugar (0 es el primero): ");
        int pos = sc.nextInt();
        //el siguiente while valida que pos1 sea correcto
        while(pos < 0 || pos >= jugador.getMano().size()){
            System.out.println("Movimiento invalido. Intente de nuevo (0 es el primero): ");
            pos = sc.nextInt();
        }
        Ficha f = jugador.getMano().get(pos);                
        boolean a= juego.agregarFichaLinea(f,jugador);//Intenta agregar la ficha
        while(!a){ //valida que se cumpla el boolean de aggficha
            System.out.println("Movimiento invalido. Intente de nuevo (0 es el primero): ");
            pos = sc.nextInt();
            while(pos < 0 || pos >= jugador.getMano().size()){
                System.out.println("Movimiento invalido. Intente de nuevo (0 es el primero): ");
                pos = sc.nextInt();
            }
            f = jugador.getMano().get(pos);                
            a= juego.agregarFichaLinea(f,jugador);
        }
        System.out.print("Nueva línea de juego -> ");
        juego.mostrarLinea();
    }
    public static void botJuego(Jugador jugador, Juego juego){
        System.out.println("-------------------\nJugador " + jugador.getNombre() +"\n-------------------");
        System.out.print("Jugador " + jugador.getNombre() +": Mano -> ");
        jugador.imprimirMano();
        System.out.println("Linea de Juego -> ");
        juego.maquina(jugador);
        juego.mostrarLinea();        
    }
}
