package Test;

import java.util.*;
import java.awt.*;
import spiderweb.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SpiderwebAtest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SpiderwebAtest
{
    /**
     * Default constructor for test class SpiderwebAtest
     */
    public SpiderwebAtest()
    {
    }
    
    @Test
    public void testSpiderMovement() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addBridge("red", 100, 2);
        spiderWeb.addBridge("blue", 150, 4);
        spiderWeb.addSpot("yellow", 3);
        spiderWeb.spiderSit(1); // Posicionar la araña en el primer hilo
        
        // Act
        spiderWeb.spiderWalk(true); // Avanzar a través del primer puente
        spiderWeb.spiderWalk(true); // Avanzar al segundo hilo
        spiderWeb.spiderWalk(true); // Avanzar a través del segundo puente
        spiderWeb.spiderWalk(true); // Avanzar al tercer hilo
        
        // Assert
        Point currentPosition = spiderWeb.getCurrentPosition();
        assertNotNull(currentPosition);
        assertEquals(300, currentPosition.getX(), 0.001); // La araña debería estar en el tercer hilo
        assertEquals(400, currentPosition.getY(), 0.001);
        String[] reachableSpots = spiderWeb.reachableSpots();
        assertTrue(Arrays.asList(reachableSpots).contains("yellow")); // Verificar si la araña puede alcanzar el punto de descanso amarillo
    }

    @Test
    public void testBridgeUtilization() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addBridge("red", 100, 2);
        spiderWeb.addBridge("blue", 150, 4);
        spiderWeb.addBridge("green", 200, 1);
        spiderWeb.spiderSit(3); // Posicionar la araña en el tercer hilo
        
        // Act
        spiderWeb.spiderWalk(true); // Avanzar al cuarto hilo a través del puente azul
        spiderWeb.spiderWalk(false); // Retroceder al tercer hilo sin utilizar ningún puente
        spiderWeb.spiderWalk(true); // Avanzar nuevamente al cuarto hilo a través del puente azul
        
        // Assert
        String[] unusedBridges = spiderWeb.unusedBridges();
        assertNull(unusedBridges); // Todos los puentes deberían estar utilizados después del recorrido de la araña
    }
    
}
