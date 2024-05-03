package spiderweb;


/**
 * Write a description of class Mobile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mobile extends Bridge{
    private int x;
    /**
     * Constructor for objects of class Normal
     */
    public Mobile(int centerX,int centerY,int x,int y,String color,int Stand) throws SpiderException{
        super(centerX,centerY,x,y,color,Stand);
    }

    public void makeInvisible(){
       if (brigde != null) {
            brigde.makeInvisible();
        }
    }
}
