/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author jmuni
 */
public class Juego {
    private ArrayList<Ficha> lineajuego;
    private ArrayList<Jugador> jugadores;
    
    public Juego(){
        this.lineajuego = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }

    public ArrayList<Ficha> getLineajuego() {
        return lineajuego;
    }
    
    public void setLineajuego(ArrayList<Ficha> lineajuego) {
        this.lineajuego = lineajuego;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public void agregarJugador(String nombre){
        jugadores.add(new Jugador(nombre, Utilitaria.crearManoJugador()));
    }
    public int obtenerValorInicioLinea(){
        return lineajuego.get(0).getLado1();
    }
    public int ObtenerValorFinLinea(){
        return lineajuego.get(lineajuego.size()-1).getLado2();
    }
    public void mostrarLinea(){
        for(int i = 0; i< lineajuego.size(); i++){
            if(i != lineajuego.size()-1)
                System.out.print(lineajuego.get(i).toString() + " - ");
            else
                System.out.println(lineajuego.get(i).toString());
        }
    }
    public boolean agregarFichaLinea(Ficha f, Jugador j){ //agrega ficha a linea(mesa); retorna booleano y remueve ficha de la mano
        boolean resultado = false;
        Scanner sc = new Scanner(System.in);
        if(f instanceof FichaComodin ){
            FichaComodin f2 = (FichaComodin) f;
            if(lineajuego.isEmpty()){
                System.out.println("Ingrese el lado 1");
                int l1 = sc.nextInt();
                System.out.println("Ingrese el lado 2");
                int l2 = sc.nextInt();
                f2.setLado1(l1);
                f2.setLado2(l2);
                lineajuego.add(f2);
                resultado = true;
                j.removerFicha(f);
                return resultado;
            }
            else{
                System.out.println("Ingrese la posición de la ficha(Inicio o Fin): ");
                String pos = sc.next();
                if (pos.equals("Inicio")){
                    System.out.println("Ingrese el valor del lado 1: ");
                    int l1 = sc.nextInt();
                    f.setLado1(l1);
                    lineajuego.add(0, f);
                    j.removerFicha(f);
                    resultado = true;
                    return resultado;
                }
                else{
                    System.out.println("Ingrese el valor del lado 2: ");
                    int l2 = sc.nextInt();
                    f.setLado2(l2);
                    lineajuego.add(f);
                    j.removerFicha(f);
                    resultado = true;
                    return resultado;
                }
            }
        }
        else{
            if (lineajuego.size()==0){
                lineajuego.add(f);
                j.removerFicha(f);
                resultado = true;
                return resultado;
            }
            else{
                if(f.getLado2() == this.obtenerValorInicioLinea() || f.getLado1() == this.ObtenerValorFinLinea()){
                    if(f.getLado2() == this.obtenerValorInicioLinea()){
                        resultado = true;
                        lineajuego.add(0, f);
                        j.removerFicha(f);
                    }
                    else if(f.getLado1() == this.ObtenerValorFinLinea()){
                        resultado = true;
                        lineajuego.add(f);
                        j.removerFicha(f);
                    }
                    return resultado;
                }
                else
                    return resultado;
            }
        }
    }
    
    public void maquina(Jugador bot){
        for(Ficha f: bot.getMano()){
            //si es f/ comodin
            if(f instanceof FichaComodin f2){
                Random rd = new Random();
                //va al inicio o al final
                boolean aleatorio1 = rd.nextBoolean();

                //si es que va al inicio
                if (aleatorio1){
                    f2.setLado1(rd.nextInt(1,7));
                    lineajuego.add(0, f2);
                    bot.removerFicha(f);
                    break;
                }
                //si es que va al final
                else{
                    f2.setLado2(rd.nextInt(1,7));
                    lineajuego.add(f2);
                    bot.removerFicha(f);
                    break;
                }
            }
            if(lineajuego.isEmpty()){
                lineajuego.add(f);
                bot.removerFicha(f);
                break;
            }else{
                    //si no es f comodin
                    if (lineajuego.isEmpty()){
                        lineajuego.add(f);
                        bot.removerFicha(f);
                        break;
                    }
                    else{
                            if(f.getLado2() == this.obtenerValorInicioLinea()){
                                lineajuego.add(0, f);
                                bot.removerFicha(f);
                                break;
                            }
                            else if(f.getLado1() == this.ObtenerValorFinLinea()){
                                lineajuego.add(f);
                                bot.removerFicha(f);
                                break;
                            }
                    }
                    
                }
            }
        }
    }
