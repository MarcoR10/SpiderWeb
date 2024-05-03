package Test;

import spiderweb.*;

import java.util.*;
import java.awt.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.jupiter.api.*;

/**
 * The test class Spiderwebc2Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Spiderwebcc2Test{   
    
    private SpiderWeb spiderWeb;

    /**
     * Configuración inicial para las pruebas.
     * Se crea una SpiderWeb con 5 hebras y un radio de 300.
     */
    @Before
    public void setUp() {
        spiderWeb = new SpiderWeb(5, 300);
    }

    /**
     * Prueba para el método addBridge().
     * Se agrega un puente de color "red" entre la hebra 2 y la 3.
     * Se verifica que se haya agregado correctamente.
     */
    @Test
    public void testAddBridge() {
        spiderWeb.addBridge("red", 50, 2);
        assertNotNull(spiderWeb.bridges());
        assertEquals(1, spiderWeb.bridges().length);
        assertEquals("red", spiderWeb.bridges()[0]);
    }

    /**
     * Prueba para el método addStrand().
     * Se agrega una nueva hebra.
     * Se verifica que se haya agregado correctamente.
     */
    @Test
    public void testAddStrand() {
        spiderWeb.addStrand();
        assertEquals(6, spiderWeb.totalStrand.size());
    }

    /**
     * Prueba para el método addSpot().
     * Se agrega una marca de color "yellow" en la hebra 3.
     * Se verifica que se haya agregado correctamente.
     */
    @Test
    public void testAddSpot() {
        spiderWeb.addSpot("yellow", 3);
        assertEquals("yellow", spiderWeb.spots().length > 0 ? spiderWeb.spots()[0] : "");
    }

    /**
     * Prueba para el método delSpot().
     * Se agrega una marca de color "green" en la hebra 3 y luego se elimina.
     * Se verifica que se haya eliminado correctamente.
     */
    @Test
    public void testDelSpot() {
        spiderWeb.addSpot("green", 3);
        spiderWeb.delSpot("green");
        assertEquals(0, spiderWeb.spots().length);
    }

    /**
     * Prueba para el método spiderLasthPath().
     * Se verifica que el camino del último arácnido sea nulo antes de que el arácnido se siente y camine.
     */
    @Test
    public void testSpiderLasthPath() {
        assertNull(spiderWeb.spiderLasthPath());
        spiderWeb.spiderSit(3);
        spiderWeb.spiderWalk(true);
    }

    /**
     * Prueba para el método reachableSpots().
     * Se verifica que los puntos alcanzables no sean nulos.
     */
    @Test
    public void testReachableSpots() {
        assertNotNull(spiderWeb.reachableSpots());
    }

    /**
     * Prueba para el método unusedBridges().
     * Se verifica que los puentes no utilizados no sean nulos.
     */
    @Test
    public void testUnusedBridges() {
        assertNotNull(spiderWeb.unusedBridges());
    }
    // Caso de prueba: addBridgeShouldAddBridge
    @Test
    public void accordingDAShouldAP() {
        // Implementación del caso de prueba
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addBridge("red", 100, 2);
        assertEquals(1, spiderWeb.bridges().length); // Se espera que haya un puente agregado
    }
    
    // Caso de prueba: delBridgeShouldRemoveBridge
    @Test
    public void delBridgeShouldRemoveBridgeAP() {
        // Implementación del caso de prueba
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addBridge("red", 100, 2);
        spiderWeb.delBridge("red");
        assertEquals(0, spiderWeb.bridges().length); // Se espera que no haya puentes después de eliminar el puente
    }
        
    // Caso de prueba: delSpotShouldRemoveSpot
    @Test
    public void delSpotShouldRemoveSpot() {
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addSpot("red", 1);
        spiderWeb.delSpot("red");
        assertEquals(0, spiderWeb.spots().length); // Se espera que no haya puntos de descanso después de eliminar uno
    }
    
    // Caso de prueba: spiderWalkShouldMoveSpider
    @Test
    public void spiderWalkShouldMoveSpider() {
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.spiderSit(1);
        spiderWeb.spiderWalk(true);
        assertNotNull(spiderWeb.getCurrentPosition()); // Se espera que la posición de la araña no sea nula después de caminar
    }
    
    /**
     * Prueba para el constructor de SpiderWeb con puentes predefinidos.
     * Se crea una SpiderWeb con 5 hebras y se agregan dos puentes.
     * Se verifica que la SpiderWeb se haya creado correctamente.
     */
    @Test
    public void testSpiderwebConstructorWithBridges() {
        // Arrange
        int strands = 5;
        int[][] bridgesData = {{50, 2}, {60, 3}};
        // Act
        SpiderWeb spiderWeb = new SpiderWeb(strands, 1, bridgesData);
        // Assert
        assertNotNull(spiderWeb);
    }

    /**
     * Prueba para el método addSpot().
     * Se crea una SpiderWeb con 5 hebras y se agrega una marca "red" en la hebra 3.
     * Se verifica que la marca "red" se haya agregado correctamente.
     */
    @Test
    public void testAddSpot2() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.addSpot("red", 3);
        // Assert
        assertEquals("red", spiderWeb.spots()[2]);
    }

    /**
     * Prueba para el método spiderSit().
     * Se crea una SpiderWeb con 5 hebras y se coloca un arácnido en la hebra 3.
     */
    @Test
    public void testSpiderSit() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.spiderSit(3);
    }

    /**
     * Prueba para el método addBridge().
     * Se crea una SpiderWeb con 5 hebras y se agrega un puente "blue" en la hebra 2.
     * Se verifica que el puente "blue" se haya agregado correctamente.
     */
    @Test
    public void testAddBridge2() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.addBridge("blue", 100, 2);        
        // Assert
        assertEquals("blue", spiderWeb.bridges()[0]); // Comprueba si el puente se agregó correctamente
    }

    /**
     * Prueba para el método relocateBridge().
     * Se crea una SpiderWeb con 5 hebras y se agrega un puente "red" en la hebra 2.
     * Luego se mueve el puente "red" a una nueva distancia.
     */
    @Test
    public void testRelocateBridge() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addBridge("red", 100, 2);
        // Act
        spiderWeb.relocateBridge("red", 150);
    }

    /**
     * Prueba para el método delBridge().
     * Se crea una SpiderWeb con 5 hebras y se agrega un puente "blue" en la hebra 2.
     * Luego se elimina el puente "blue".
     */
    @Test
    public void testDelBridge() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addBridge("blue", 100, 2);
        // Act
        spiderWeb.delBridge("blue");
    }
    
     @Test
    public void testAddStrand2() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        int initialStrandCount = spiderWeb.totalStrand.size();
        
        // Act
        spiderWeb.addStrand();
        
        // Assert
        assertEquals(initialStrandCount + 1, spiderWeb.totalStrand.size());
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
    
    /**
     * Prueba para el constructor de SpiderWeb con puentes predefinidos.
     * Se crea una SpiderWeb con 5 hebras y se agregan dos puentes.
     * Se verifica que la SpiderWeb se haya creado correctamente.
     */
    @Test
    public void testSpiderwebConstructorWithBridges2() {
        // Arrange
        int strands = 5;
        int[][] bridgesData = {{50, 2}, {60, 3}};
        // Act
        SpiderWeb spiderWeb = new SpiderWeb(strands, 1, bridgesData);
        // Assert
        assertNotNull(spiderWeb);
    }

    /**
     * Prueba para el método addSpot().
     * Se crea una SpiderWeb con 5 hebras y se agrega una marca "red" en la hebra 3.
     * Se verifica que la marca "red" se haya agregado correctamente.
     */
    @Test
    public void testAddSpot3() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.addSpot("red", 3);
        // Assert
        assertEquals("red", spiderWeb.spots()[2]);
    }

    /**
     * Prueba para el método spiderSit().
     * Se crea una SpiderWeb con 5 hebras y se coloca un arácnido en la hebra 3.
     */
    @Test
    public void testSpiderSit2() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.spiderSit(3);
    }

    /**
     * Prueba para el método addBridge().
     * Se crea una SpiderWeb con 5 hebras y se agrega un puente "blue" en la hebra 2.
     * Se verifica que el puente "blue" se haya agregado correctamente.
     */
    @Test
    public void testAddBridge3() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.addBridge("blue", 100, 2);        
        // Assert
        assertEquals("blue", spiderWeb.bridges()[0]); // Comprueba si el puente se agregó correctamente
    }

    /**
     * Prueba para el método relocateBridge().
     * Se crea una SpiderWeb con 5 hebras y se agrega un puente "red" en la hebra 2.
     * Luego se mueve el puente "red" a una nueva distancia.
     */
    @Test
    public void testRelocateBridge2() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addBridge("red", 100, 2);
        // Act
        spiderWeb.relocateBridge("red", 150);
    }

    /**
     * Prueba para el método delBridge().
     * Se crea una SpiderWeb con 5 hebras y se agrega un puente "blue" en la hebra 2.
     * Luego se elimina el puente "blue".
     */
    @Test
    public void testDelBridge2() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addBridge("blue", 100, 2);
        // Act
        spiderWeb.delBridge("blue");
    }
    
     /**
     * Prueba para el método addSpot() con una entrada válida.
     * Se crea una SpiderWeb con 5 hebras y se agrega una marca "blue" en la hebra 3.
     * Se verifica que se haya agregado al menos una marca.
     */
    @Test
    public void testAddSpotValidInput() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.addSpot("blue", 3);
        // Assert
        assertTrue(spiderWeb.spots().length > 0);
    }
    
    /**
     * Prueba para el método addSpot() con un índice de hebra no válido.
     * Se crea una SpiderWeb con 5 hebras.
     * Se intenta agregar una marca "green" en una hebra inexistente (índice 6).
     * Se verifica que ninguna marca se haya agregado.
     */
    @Test
    public void testAddSpotInvalidStrandIndex() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.addSpot("green", 6);
        // Assert
        assertEquals(0, spiderWeb.spots().length);
    }
    
    /**
     * Prueba para el método delSpot() con una entrada válida.
     * Se crea una SpiderWeb con 5 hebras y se agrega una marca "yellow" en la hebra 2.
     * Luego se elimina la marca "yellow".
     * Se verifica que ninguna marca esté presente después de eliminarla.
     */
    @Test
    public void testDelSpotValidInput() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addSpot("yellow", 2);
        // Act
        spiderWeb.delSpot("yellow");
        // Assert
        assertFalse(spiderWeb.spots().length > 0);
    }
    
    /**
     * Prueba para el método delSpot() con un color inexistente.
     * Se crea una SpiderWeb con 5 hebras.
     * Se intenta eliminar una marca "red" que no existe.
     * Se verifica que ninguna marca se haya eliminado.
     */
    @Test
    public void testDelSpotNonexistentColor() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.delSpot("red");
        // Assert
        assertEquals(0, spiderWeb.spots().length);
    }
    
    /**
     * Prueba para el método reachableSpots() cuando no hay marcas disponibles.
     * Se crea una SpiderWeb con 5 hebras.
     * Se verifica que no haya marcas disponibles para alcanzar.
     */
    @Test
    public void testReachableSpotsNoSpotsAvailable() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        String[] reachableSpots = spiderWeb.reachableSpots();
        // Assert
        assertEquals(0, reachableSpots.length);
    }
    
    /**
     * Prueba para el método reachableSpots() cuando hay marcas disponibles.
     * Se crea una SpiderWeb con 5 hebras y se agregan tres marcas.
     * Se verifica que las marcas estén disponibles para alcanzar.
     */
    @Test
    public void testReachableSpotsWithAvailableSpots() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addSpot("red", 2);
        spiderWeb.addSpot("green", 4);
        spiderWeb.addSpot("blue", 5);
        // Act
        String[] reachableSpots = spiderWeb.reachableSpots();
    }

}
