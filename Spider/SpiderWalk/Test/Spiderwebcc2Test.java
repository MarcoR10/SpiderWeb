package Test;

import spiderweb.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class Spiderwebc2Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Spiderwebcc2Test
{
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
}
