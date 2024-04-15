package spiderweb;

import canvas.*;
import canvas.Canvas;
import java.awt.Color;
import java.util.Random;
import java.awt.*;

/**
 * Clase Spider representa una araña compuesta por una cabeza y dos ojos.
 */
public class Spider {
    
    private Circle cabeza,ojoiz,ojode;
    private int diameter,xPosition,yPosition,strand;
    private String color;
    private boolean isVisible,center;
    private Random random;
    
    /**
     * Constructor de la clase Spider.
     * @param xPosition posición x inicial de la araña.
     * @param yPosition posición y inicial de la araña.
     */
    public Spider(int xPosition, int yPosition,int Strand) {
        cabeza = new Circle();
        ojoiz = new Circle();
        ojode = new Circle();
        strand = Strand;
        isVisible = true;
        center = false;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        draw(xPosition, yPosition);
    }
    
    /**
     * Dibuja la araña en la posición especificada.
     * @param xPosition posición x donde se dibujará la araña.
     * @param yPosition posición y donde se dibujará la araña.
     */
    public void draw(int xPosition, int yPosition) {
        if (isVisible) {
            cabeza.moveHorizontal(xPosition - 15);
            cabeza.moveVertical(yPosition - 15);
            cabeza.makeVisible();
            //
            ojoiz.changeSize(10);
            ojoiz.changeColor("red");
            ojoiz.moveHorizontal(xPosition);
            ojoiz.moveVertical(yPosition - 10);
            ojoiz.makeVisible();
            //
            ojode.changeSize(10);
            ojode.changeColor("red");
            ojode.moveHorizontal(xPosition - 10);
            ojode.moveVertical(yPosition - 10);
            ojode.makeVisible();
        }
    }
    
    /**
     * Método que simula el movimiento de la araña.
     */
    public void spiderWalk(boolean advance, Point[] Camino) {
        if (advance && center == true) {
            center = false;
            if (Camino.length >= 10) {  // Verificar la longitud del array Camino
                for (int i = 0; i < 10; i++) {
                    Point punto = Camino[i];
                    draw(punto.x, punto.y);
                }
            } else {
                System.out.println("El array Camino debe tener al menos 10 elementos.");
            }
        } else if (!advance && center == false) {
            center = true;
            if (Camino.length >= 10) {  // Verificar la longitud del array Camino
                for (int j = 9; 0 <= j; j--) {
                    Point punto = Camino[j];
                    draw(punto.x, punto.y);
                }
            } else {
                System.out.println("El array Camino debe tener al menos 10 elementos.");
            }
        }
    }

    
    /**
     * Hace visible a la araña.
     */
    public void makeVisible() {
        isVisible = true;
        cabeza.makeVisible();
        ojode.makeVisible();
        ojoiz.makeVisible();
    }
    
    /**
     * Hace invisible a la araña.
     */
    public void makeInvisible() {
        isVisible = false;
        cabeza.makeInvisible();
        ojode.makeInvisible();
        ojoiz.makeInvisible();
    }
    
    /**
     * 
     */
    public int getStrand() {
        return strand;
    }
    
    /**
     * Obtiene el estado de visibilidad de la araña.
     * @return true si la araña es visible, false en caso contrario.
     */
    public boolean getVisibilidad() {
        return isVisible;
    }
    
}
