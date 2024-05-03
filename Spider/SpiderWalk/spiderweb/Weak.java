package spiderweb;


/**
 * Write a description of class Weak here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weak extends Bridge{
   
    /**
     * Constructor for objects of class Weak
     */
    public Weak(int centerX,int centerY,int x,int y,String color,int Stand) throws SpiderException{
        super(centerX,centerY,x,y,color,Stand);
    }

    public void makeInvisible(){
       if (brigde != null) {
            brigde.makeInvisible();
        }
    }
}
