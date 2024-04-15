package Test;


import spiderweb.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class spiderwebC4test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class spiderwebC4test{
    @Test
    public void testAddSpotValidInput() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.addSpot("blue", 3);
        // Assert
        assertTrue(spiderWeb.spots().length > 0);
    }
    
    @Test
    public void testAddSpotInvalidStrandIndex() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.addSpot("green", 6);
        // Assert
        assertEquals(0, spiderWeb.spots().length);
    }
    
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
    
    @Test
    public void testDelSpotNonexistentColor() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.delSpot("red");
        // Assert
        assertEquals(0, spiderWeb.spots().length);
    }
    
    @Test
    public void testReachableSpotsNoSpotsAvailable() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        String[] reachableSpots = spiderWeb.reachableSpots();
        // Assert
        assertEquals(0, reachableSpots.length);
    }
    
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
