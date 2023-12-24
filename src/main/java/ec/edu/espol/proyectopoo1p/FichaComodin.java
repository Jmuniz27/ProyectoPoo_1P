/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;

/**
 *
 * @author jmuni
 */
public class FichaComodin extends Ficha {
    
    public FichaComodin() {
        super(-1,-1);
    }

    public void setLado1(int v) {
        this.lado1 = v;
    }

    public void setLado2(int v) {
        this.lado2 = v;
    }

    @Override
    public String toString() {
        return "*" +super.toString()+ "*";
    }
}
