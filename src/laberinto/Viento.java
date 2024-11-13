/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto;

/**
 *
 * @author jsh
 */
public class Viento extends Adversidad {

    /**
     * Constructor Parametrizado
     * @param nombre de la adversidad
     * @param posicion podicion en la que se encuentra
     */
    public Viento(String nombre, int posicion) {
        super(nombre, posicion);
    }

    /**
     * Metodo heredado de Adversidad que hace el ataque de la adversidad 
     * viento al personaje
     * @param p personaje que es atacado
     * @param m mapa en el que se encuentra la adversidad
     * @return devuelve un mensaje de ataque
     */
    @Override
    public String atacar(Personaje p, Mapa m) {
        p.setSActual(0);
        p.volverRuta(m);
        return "Adversidad " + super.getNombre() + " atacando a Harry";
        
        
    }
    
    
    
    
}
