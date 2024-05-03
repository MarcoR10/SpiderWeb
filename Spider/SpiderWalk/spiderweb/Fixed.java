package spiderweb;


/**
 *
 */
public class Fixed extends Bridge{
    
    /**
     * Constructor for objects of class fixed
     */
    public Fixed(int centerX,int centerY,int x,int y,String color,int Stand) throws SpiderException{
        super(centerX,centerY,x,y,color,Stand);
    }
    
    public void makeInvisible(){
        System.out.println("Este puente no se puede Hacer Desacer");
    }
}
