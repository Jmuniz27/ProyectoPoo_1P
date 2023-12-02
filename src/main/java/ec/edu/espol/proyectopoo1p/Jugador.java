/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;

import java.util.ArrayList;

/**
 *
 * @author jmuni
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;

    public ArrayList<Ficha> getMano() {
        return mano;
    }

    public Jugador(String nombre, ArrayList<Ficha> mano) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Ficha getFicha(int i) {
        if (i-1 < mano.size() && i-1>=0)
            return this.mano.get(i-1);
        else
            return null;
    }
    
    public void imprimirMano(){
        int count = 0;
        for (Ficha ficha : mano){
            count++;
            if (mano.size() != count)
                System.out.print(ficha.toString()+"-");
            else
                System.out.println(ficha.toString());
        }
    }
    
    public void removerFicha(Ficha f){
        for (Ficha ficha : mano){
            if ((f.getLado1() == ficha.lado1) && (f.getLado2() == ficha.lado2))
            {
                mano.remove(ficha);
                break;
            }
        }
        
    }
}
