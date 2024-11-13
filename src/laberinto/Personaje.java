/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto;

import java.util.LinkedList;

/**
 *
 * @author jsh
 */
public class Personaje {
    private int sActual;
    private LinkedList<Direccion> ruta;
    private int salud;
    
    /**
     * Constructor Parametrizado
     * @param m  es el mapa en el que se encuenta el perosnaje
     */
    public Personaje(Mapa m) {
        sActual = m.getSInicial();
        ruta = new LinkedList<Direccion>();
        calcularRuta(m, new LinkedList<Integer>());
        m.setJugador(this);
        salud = 100;
    }

    
    public int getSActual() {
        return sActual;
    }

   
    public void setSActual(int sActual) {
        this.sActual = sActual;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getsActual() {
        return sActual;
    }

    public void setsActual(int sActual) {
        this.sActual = sActual;
    }

    public LinkedList<Direccion> getRuta() {
        return ruta;
    }

    public void setRuta(LinkedList<Direccion> ruta) {
        this.ruta = ruta;
    }

  
    
    /**
     * Metodo que sirve para mover al personaje dependiendo de la ruta
     * 
     * @param m es el mapa.
     */
    public void mover(Mapa m) {
        Direccion d = ruta.remove();
        switch (d) {
            case S:
                sActual = sActual + m.getAncho();
                break;
            case E:
                sActual = sActual + 1;
                break;
            case O:
                sActual = sActual - 1;
                break;
            case N:
                sActual = sActual - m.getAncho();
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }
    
    /**
     * Metodo booleano para calcular la ruta que debe seguir el personaje
     * @param mapa es el mapa en el que hay que calcular la ruta
     * @param salasVisitadas lista de salas que ha visitado
     * @return es un booleano para saber si puede seguir o no
     */

   private boolean calcularRuta(Mapa mapa, LinkedList<Integer> salasVisitadas) {
        if (sActual == mapa.getSFinal()) {
            sActual = 0;
            return true;
        } else {
            int x = sActual % mapa.getAncho();
            int y = sActual / mapa.getAncho();
            if (y < mapa.getAlto() - 1 && !mapa.hayPared(sActual, sActual + mapa.getAncho()) && !salasVisitadas.contains(sActual + mapa.getAncho())) {
                salasVisitadas.add(sActual + mapa.getAncho());
                ruta.add(Direccion.S);
                sActual = sActual + mapa.getAncho();
                if (!calcularRuta(mapa, salasVisitadas)) {
                    sActual = sActual - mapa.getAncho();
                    ruta.removeLast();
                } else
                    return true;
            }
            if (x < mapa.getAncho() - 1 && !mapa.hayPared(sActual, sActual + 1) && !salasVisitadas.contains(sActual + 1)) {
                salasVisitadas.add(sActual + 1);
                ruta.add(Direccion.E);
                sActual = sActual + 1;
                if (!calcularRuta(mapa, salasVisitadas)) {
                    sActual = sActual - 1;
                    ruta.removeLast();
                } else
                    return true;
            }
            if (x > 0 && !mapa.hayPared(sActual, sActual - 1) && !salasVisitadas.contains(sActual - 1)) {
                salasVisitadas.add(sActual - 1);
                ruta.add(Direccion.O);
                sActual = sActual - 1;
                if (!calcularRuta(mapa, salasVisitadas)) {
                    sActual = sActual + 1;
                    ruta.removeLast();
                } else
                    return true;
            }
            if (y > 0 && !mapa.hayPared(sActual, sActual - mapa.getAncho()) && !salasVisitadas.contains(sActual - mapa.getAncho())) {
                salasVisitadas.add(sActual - mapa.getAncho());
                ruta.add(Direccion.N);
                sActual = sActual - mapa.getAncho();
                if (!calcularRuta(mapa, salasVisitadas)) {
                    sActual = sActual + mapa.getAncho();
                    ruta.removeLast();
                } else
                    return true;
            }
        }
        return false;
    }

   /**
    * Metodo en el cual se reinicia la ruta del personaje cuando se enfrenta
    * a la adversidad viento
    * @param m es el mapa
    */
    public void volverRuta(Mapa m) {
        if (sActual == 0) {
            ruta.clear();
            calcularRuta(m, new LinkedList<Integer>());
        }
    }
    
}
