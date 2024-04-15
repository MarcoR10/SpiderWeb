package spiderweb;
import java.awt.*;

/**
 * Write a description of class Bridge here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bridge{
    
    protected int centerX,centerY,x,y,stand;
    protected Line brigde;
    protected String color;
    protected boolean used;
    
    /**
     * Constructor for objects of class Bridge
     */
    public Bridge(int centerX,int centerY,int x,int y,String color,int Stand ){
        this.centerX = centerX;
        this.centerY = centerY;
        this.x = x;
        this.y = y;
        this.color = color;
        stand = Stand;
        brigde = new Line(centerX, centerY, x, y,color);
        makeVisible();
    }
    
    public int getStand(){
        return stand;
    }

    /**
     */
    public void makeVisible(){
        brigde.makeVisible();
    }
    
    public void makeInvisible(){
        if (brigde != null) {
            brigde.makeInvisible();
        }
    }
    
    public void setColor(String color){
        this.color = color;
        makeVisible();
    }
    
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
