/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto;

/**
 *
 * @author jsh
 */
public class Pared {
    private int corX;
    private int corY;

    /**
     * Constructor Parametrizado
     * @param x coordenada x
     * @param y coordenada y
     */
    public Pared(int x, int y) {
        this.corX = x;
        this.corY = y;
    }

    public int getX() {
        return corX;
    }

    public void setX(int x) {
        this.corX = x;
    }

    public int getY() {
        return corY;
    }

    public void setY(int y) {
        this.corY = y;
    }

    
}

