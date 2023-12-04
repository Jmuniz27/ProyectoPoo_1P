/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyectopoo1p;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author juanmuni, ansaguzm, adotero
 */
public class ProyectoPOO1P {

    public static void main(String[] args) {
        Juego juego = new Juego();
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------\nBienvenido a Domino\n-------------------");
        System.out.println("MENÚ\n1. Multijugador\n2. Solo");
        System.out.println("Seleccione modo de juego(1 o 2): ");
        int modo = sc.nextInt();
        //selecciona el modo de juego --- si es multijugador
        if(modo==1){
            System.out.print("Ingrese nombre Jugador 0>> ");
            String j = sc.next();
            juego.agregarJugador(j);
            System.out.print("Ingrese nombre Jugador 1>> ");
            String j2 = sc.next();
            juego.agregarJugador(j2);
            //crea jugadores, instancias
            Jugador jugador0 = juego.getJugadores().get(0);
            Jugador jugador1 = juego.getJugadores().get(1);
            do{ //AMBOS jugadores deben de poder jugar para que el juego siga
                //JUGADOR0 
                ProyectoPOO1P.jugadorJuego(jugador0, juego);
                
                //JUGADOR1
                ProyectoPOO1P.jugadorJuego(jugador1, juego);
                
                //caso en el cual, el jug0 no puede jugar pero el otro (juga1) tiene un comodin
                if(!jugador0.jugabilidad(juego) || !jugador1.jugabilidad(juego)){
                    if(!jugador0.jugabilidad(juego) && jugador1.tieneComodin()){
                        ProyectoPOO1P.jugadorJuego(jugador1, juego);
                    }
                    else if(!jugador1.jugabilidad(juego) && jugador0.tieneComodin()){
                        ProyectoPOO1P.jugadorJuego(jugador0, juego);
                    }
                }
                }while(jugador0.jugabilidad(juego) && jugador1.jugabilidad(juego));
            //imprimir quien gana y pierde
            if(jugador0.jugabilidad(juego)==false){
                if(jugador0.getMano().size()==0)
                    System.out.println("El jugador "+jugador0.getNombre()+" gana ya que jugó sus fichas. El jugador "+jugador1.getNombre()+ " pierde.");
                else
                    System.out.println("El jugador "+jugador0.getNombre()+" ya no puede jugar fichas. El jugador "+jugador1.getNombre()+ " gana.");
            }
            else{
                if(jugador1.getMano().size()==0)
                    System.out.println("El jugador "+jugador1.getNombre()+" gana ya que jugó sus fichas. El jugador "+jugador0.getNombre()+ " pierde.");
                else
                    System.out.println("El jugador "+jugador1.getNombre()+" ya no puede jugar fichas. El jugador "+jugador0.getNombre()+ " gana.");               
            }
            }
        
        //pelea contra maquina - modo 2
        else if(modo == 2){
            //ingresa el usuario q juega contra la maquina 
            System.out.print("Ingrese su nombre>> ");
            String solo = sc.next();
            juego.agregarJugador(solo);
            
            //se crea al bot
            juego.agregarJugador("bot");
            
            //jugadores - instancias
            Jugador jugador = juego.getJugadores().get(0);
            Jugador bot = juego.getJugadores().get(1);
            Random rd = new Random();
            //random de bool
            boolean primero = rd.nextBoolean();
            while(jugador.jugabilidad(juego) && bot.jugabilidad(juego)){
                //escoger quien inicia primero si bot o jugador
                if(primero){
                    //inicio jugador
                    ProyectoPOO1P.jugadorJuego(jugador, juego);
                    ProyectoPOO1P.botJuego(bot, juego);
                    //caso en el cual, el jug no puede jugar pero el otro (bot) tiene un comodin y vice 
                    if(!jugador.jugabilidad(juego) || !bot.jugabilidad(juego)){
                        if(!jugador.jugabilidad(juego) && bot.tieneComodin()){
                            ProyectoPOO1P.botJuego(bot, juego);
                        }
                        if(!bot.jugabilidad(juego) && jugador.tieneComodin()){
                            ProyectoPOO1P.jugadorJuego(jugador, juego);
                        }
                    }
                }
                else{
                    //inicia bot
                    ProyectoPOO1P.botJuego(bot, juego);
                    ProyectoPOO1P.jugadorJuego(jugador, juego); 
                    //caso en el cual, el jug no puede jugar pero el otro (bot) tiene un comodin y vice
                    if(!jugador.jugabilidad(juego) || !bot.jugabilidad(juego)){
                        if(!jugador.jugabilidad(juego) && bot.tieneComodin()){
                            ProyectoPOO1P.jugadorJuego(bot, juego);
                        }
                        else if(!bot.jugabilidad(juego) && jugador.tieneComodin()){
                            ProyectoPOO1P.jugadorJuego(jugador, juego);
                        }
                }
            }
            //imprimir quien gana y pierde
            if(jugador.jugabilidad(juego)==false){
                if(jugador.getMano().size()==0)
                    System.out.println("El jugador "+jugador.getNombre()+" gana ya que jugó sus fichas. El jugador "+bot.getNombre()+ " pierde.");
                else
                    System.out.println("El jugador "+jugador.getNombre()+" ya no puede jugar fichas. El jugador "+bot.getNombre()+ " gana.");
            }
            else{
                if(bot.getMano().size()==0)
                    System.out.println("El jugador "+bot.getNombre()+" gana ya que jugó sus fichas. El jugador "+jugador.getNombre()+ " pierde.");
                else
                    System.out.println("El jugador "+bot.getNombre()+" ya no puede jugar fichas. El jugador "+jugador.getNombre()+ " gana.");               
            }
        }
    }
}
    //metodos pa jugar
    // imprimi, recibe y modifica, las fichas, lineaJuego y mano
    public static void jugadorJuego(Jugador jugador, Juego juego){
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------\nJugador " + jugador.getNombre() +"\n-------------------");
        System.out.print("Jugador " + jugador.getNombre() +": Mano -> ");
        jugador.imprimirMano();
        System.out.println("Linea de Juego -> ");
        juego.mostrarLinea();

        System.out.print("Indice de ficha para jugar (0 es el primero): ");
        int pos = sc.nextInt();
        //el siguiente while valida que pos1 sea correcto --- validacion
        while(pos < 0 || pos >= jugador.getMano().size()){
            System.out.println("Movimiento invalido. Intente de nuevo (0 es el primero): ");
            pos = sc.nextInt();
        }
        Ficha f = jugador.getMano().get(pos);                
        boolean a= juego.agregarFichaLinea(f,jugador);//Intenta agregar la ficha
        while(!a){ //valida que se cumpla el boolean de aggficha
            //si no
            System.out.println("Movimiento invalido. Intente de nuevo (0 es el primero): ");
            pos = sc.nextInt();
            //validacion
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
    //comportamiento del bot mientras jeuga
    public static void botJuego(Jugador jugador, Juego juego){
        System.out.println("-------------------\nJugador " + jugador.getNombre() +"\n-------------------");
        System.out.print("Jugador " + jugador.getNombre() +": Mano -> ");
        jugador.imprimirMano();
        System.out.println("Linea de Juego -> ");
        juego.maquina(jugador);
        juego.mostrarLinea();        
    }
}
