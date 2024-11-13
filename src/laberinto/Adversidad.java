/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto;

/**
 *
 * @author jsh
 */
public abstract class Adversidad {
   private int posicion;
   private String nombre;

   /**
    * Constructor parametrizado
    * @param nombre de la adversidad
    * @param posicion sala de la adversidad
    */
    public Adversidad(String nombre, int posicion) {
        this.posicion = posicion;
        this.nombre = nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /**
     * Metodo abstracto de la adversidad, segun que adversidad sea realiza una cosa u otra
     * @param p es el personaje al que se ataca
     * @param m es en mapa en el que se encuentran las adversidades
     */
    public abstract String atacar(Personaje p, Mapa m);
  
   
    
    
    
}
