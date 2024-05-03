package spiderweb;

import java.awt.*;

/**
 * La clase Bridge representa un puente en una tela de araña.
 * Un puente es una estructura abstracta que conecta dos puntos en la tela de araña.
 * Esta clase es abstracta y proporciona métodos comunes para los diferentes tipos de puentes.
 * Los puentes pueden ser visibles o invisibles y pueden tener diferentes colores.
 * Además, un puente puede ser marcado como utilizado.
 * 
 * Esta clase se espera que sea extendida por clases concretas que implementen métodos específicos para tipos particulares de puentes.
 * 
 * @author Nombre del autor
 * @version Versión del programa o fecha de creación
 */
public abstract class Bridge{
    
    // Variables de instancia protegidas para representar las coordenadas del puente, su color, si ha sido utilizado y otros detalles.
    protected int centerX, centerY, x, y, stand;
    protected Line brigde; // La línea que representa visualmente el puente.
    protected String color; // El color del puente.
    protected boolean used; // Indica si el puente ha sido utilizado.
    
    /**
     * Constructor para objetos de la clase Bridge.
     * 
     * @param centerX La coordenada X del centro del puente.
     * @param centerY La coordenada Y del centro del puente.
     * @param x La coordenada X del extremo del puente.
     * @param y La coordenada Y del extremo del puente.
     * @param color El color del puente.
     * @param stand El índice del hilo en el que se encuentra el puente.
     */
    public Bridge(int centerX, int centerY, int x, int y, String color, int stand) throws spiderweb.SpiderException{
        // Inicialización de las variables de instancia con los valores proporcionados.
        this.centerX = centerX;
        this.centerY = centerY;
        this.x = x;
        this.y = y;
        this.color = color;
        this.stand = stand;
        
        // Creación de la línea visual que representa el puente y se hace visible.
        brigde = new Line(centerX, centerY, x, y, color);
        makeVisible();
    }
    
    /**
     * Obtiene el índice del hilo en el que se encuentra el puente.
     * 
     * @return El índice del hilo.
     */
    public int getStand(){
        return stand;
    }

    /**
     * Hace visible el puente.
     */
    public void makeVisible() throws SpiderException{
        try{
            brigde.makeVisible();
        }catch (Exception e){
            throw new SpiderException(SpiderException.NO_EXITEN_PUENTES);
        }
    }
    
    /**
     * Hace invisible el puente. Este método es abstracto y debe ser implementado por las subclases.
     */
    public abstract void makeInvisible();
    
    /**
     * Cambia el color del puente y lo hace visible.
     * 
     * @param color El nuevo color del puente.
     */
    public void setColor(String color) throws SpiderException{
        this.color = color;
        makeVisible();
    }
    
    /**
     * Obtiene las coordenadas del extremo del puente.
     * 
     * @return Las coordenadas del extremo del puente.
     */
    public Point getCoords(){
       return new Point(x,y); 
    }
    
    /**
     * Marca este puente como utilizado.
     */
    public void markAsUsed() {
        this.used = true;
    }
    
    /**
     * Verifica si este puente ha sido utilizado.
     * 
     * @return true si el puente ha sido utilizado, false de lo contrario.
     */
    public boolean isUsed() {
        return used;
    }
  
}

