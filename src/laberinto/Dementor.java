/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto;

/**
 *
 * @author jsh
 */
public class Dementor extends Adversidad {
    
    /**
     * Constructor parametrizado
     * @param posicion donde se encuentra el dementor
     */

    public Dementor(int posicion) {
        super("Dementor", posicion);
    }

    /**
     * Metodo para atacar al personaje, todos los ataques de los dementores 
     * restan 30 de vida
     * @param p personaje que es atacado
     * @param m mapa en el que se encuentra el dementor
     * @return devuelve un mensaje de ataque
     */
   
 @Override
    public String atacar(Personaje p, Mapa m) {
        p.setSalud(p.getSalud() - 30);
        return  "Adversidad " + super.getNombre() +" atacando a Harry";
    }
    

    

    
    

   
    
    
    
}
