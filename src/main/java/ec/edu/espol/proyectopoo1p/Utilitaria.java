/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jmuni
 */
public class Utilitaria {
    public static ArrayList<Ficha> crearManoJugador(){
        Random rd = new Random();
        ArrayList<Ficha> manojug = new ArrayList<>();
        int aleatorio1;
        int aleatorio2;
        for (int i = 0; i < 5 ; i++)
        {
            aleatorio1 = rd.nextInt(1,6);
            aleatorio2 = rd.nextInt(1,6);
            Ficha n = new Ficha(aleatorio1,aleatorio2);
            manojug.add(n);
        }
        return manojug;
    }
}
