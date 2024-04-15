package spiderweb;


/**
 * Write a description of class SpiderException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpiderException extends Exception{
    
    public static final String CASCARON_ERRORES = "prueba error ";
    public static final String NO_EXITEN_PUENTES = "No se encontraron los puentes necesarios para el punto requerido";
    
    /**
     * Constructor for objects of class SpiderException
     */
    public SpiderException(String message){
        super(message);
    }
}
