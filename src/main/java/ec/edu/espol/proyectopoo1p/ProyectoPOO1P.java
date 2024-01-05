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
        System.out.println("-------------------\nBienvenido a Domino\n-------------------");
        
        
        juego.agregarJugador("User");
        juego.agregarJugador("Bot");

        //jugadores - instancias
        Jugador jugador = juego.getJugadores().get(0);
        Jugador bot = juego.getJugadores().get(1);
        Random rd = new Random();
        //random de bool
        boolean primero = rd.nextBoolean(); //escoger quien inicia primero si bot o jugador
            
        if(primero){
            //inicio jugador
            while(jugador.jugabilidad(juego) && bot.jugabilidad(juego)){
                jugador.jugadorJuego(juego);
                if(bot.jugabilidad(juego))
                    bot.botJuego(juego);
            }
            
            
        }else{
            //inicia bot
            while(jugador.jugabilidad(juego) && bot.jugabilidad(juego)){
                bot.botJuego(juego);
                if(jugador.jugabilidad(juego))
                    jugador.jugadorJuego(juego); 
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
