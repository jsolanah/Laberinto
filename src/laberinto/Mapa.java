/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto;

import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author jsh
 */
public class Mapa {

    private int alto;
    private int ancho;
    LinkedList<Pared> paredes;
    private Personaje jugador;
    private LinkedList<Adversidad> adversidad;
    static String ruta = "C:/Users/jsh/Documents/NetBeansProjects/Laberinto/src/laberinto/registro.log";
   
    /**
     * Constructor Parametrizado
     * @param alto del mapa
     * @param ancho del mapa
     */
    public Mapa(int alto, int ancho) {
        this.ancho = ancho;
        this.alto = alto;
        this.paredes = new LinkedList<>();
        this.jugador = jugador;
        this.adversidad = new LinkedList<>();
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public LinkedList<Pared> getParedes() {
        return paredes;
    }

    public void setParedes(LinkedList<Pared> paredes) {
        this.paredes = paredes;
    }

    public Personaje getJugador() {
        return jugador;
    }

    public void setJugador(Personaje jugador) {
        this.jugador = jugador;
    }

    public LinkedList<Adversidad> getAdversidad() {
        return adversidad;
    }

    public void setAdversidad(LinkedList<Adversidad> adversidad) {
        this.adversidad = adversidad;
    }

    /**
     * Metodo para añadir pared en la posición de las cordenadas X e Y
     *
     * @param x cordenada x de la pared
     * @param y cordenada y de la pared
     */
    public void aniadirPared(int x, int y) {
        Pared p = new Pared(x, y);
        if (!hayPared(x, y)) {
            paredes.add(p);
        }
    }

    /**
     * Metodo que mira si hay una pared en las posiciones absolutas X e Y
     *
     * @param x posicion absoluta que indica una poscion en el mapa
     * @param y posicion absoluta que indica una poscion en el mapa
     * @return devuelve un booleano para saber si hay una pared o no hay pared
     */
    public boolean hayPared(int x, int y) {
        for (int i = 0; i < paredes.size(); i++) {

            if (paredes.get(i).getX() == y && paredes.get(i).getY() == x
                    || paredes.get(i).getX() == x && paredes.get(i).getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     *  
     * @return devuelve el mapa
     */
    @Override
    public String toString() {

        String mapa = "";
        for (int i = 0; i < ancho; i++) {
            mapa += " _";
        }
        mapa += '\n';
        for (int i = 0; i < alto; i++) {
            mapa += "|";
            for (int j = 0; j < ancho; j++) {
                int pos = i * ancho + j;

                if (jugador != null && pos == jugador.getSActual()) {
                    mapa += "H";

                } else if (i == alto - 1) {
                    mapa += "_";

                } else {

                    if (hayPared(pos, pos + ancho)) {
                        mapa += "_";
                    } else {
                        mapa += " ";
                    }

                }
                if (j == ancho - 1) {
                    mapa += "|";
                } else {
                    if (hayPared(pos, pos + 1)) {
                        mapa += "|";
                    } else {
                        mapa += " ";
                    }
                }

            }

            mapa += '\n';
        }

        return mapa;

    }

    /**
     * Metodo para conseguir la Sala Inicial del mapa, siempre es la 0
     *
     * @return int
     */
    public int getSInicial() {
        return 0;
    }

    /**
     * Metodo para saber cual es la ultima sala del mapa, para eso multiplicamos
     * el ancho y el alto y le restamos 1 al resultado de la multiplicación
     *
     * @return int
     */
    public int getSFinal() {
        return (alto * ancho) - 1;
    }

    /**
     * Añade una nueva adversidad
     *
     * @param a
     */
    public void nuevaAdversidad(Adversidad a) {
        adversidad.add(a);
    }
    
    /**
     * Metodo para saber si hay una adversidad
     * @return es el mensaje que mostrara cuando un personaje es atacado
     */
    public String hayAdversidad(){
        for (int i = 0; i < adversidad.size(); i++) {
                if (jugador.getSActual() == adversidad.get(i).getPosicion())
                   return adversidad.remove(i).atacar(jugador, this);
            }
        return "";
    }

    /**
     * Metodo pra dibujaar el mapa con el personaje y los ataques, tambien se 
     * usa para añadir la ejecucion en el fichero llamado "registro.log"
     */
    public void avanzarTurno() {
        try(PrintWriter escritor = new PrintWriter(ruta, "UTF-8");) {
            String copia = "";
            copia += "COMIENZA LA BATALLA \n";
        int count = 0;
        copia += "Turno: " + count + ", Salud de Harry: " + jugador.getSalud() +"\n";
        copia += toString() +"\n";
        do {
            jugador.mover(this);
            count++;

            if (count % 10 == 0) {
                jugador.setSalud(jugador.getSalud() - 20);
            }

            if (jugador.getSalud() <= 0) {
                copia +="Harry no ha conseguido salir del laberinto :( \n";
                break;
            }
            copia += "Turno: " + count + " Salud de Harry: " + jugador.getSalud() +"\n";
           
            copia += hayAdversidad()+"\n";
            
            copia += toString()+"\n";

            if (jugador.getSActual() == getSFinal()) {
                copia += "HARRY HA GANADO EL JUEGO :)\n ";
            }

        } while (jugador.getSActual() != getSFinal());
            System.out.println(copia);
            escritor.println(copia);
            count = 0;
            
            
            
        } catch (Exception e) {
        }
        
    }
}
