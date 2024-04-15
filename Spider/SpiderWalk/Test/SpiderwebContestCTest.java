package Test;
import org.junit.*;
import static org.junit.Assert.*;
import spiderweb.*;

public class SpiderwebContestCTest {

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

    @Test
    public void testAddSpot() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.addSpot("red", 3);
        // Assert
        assertEquals("red", spiderWeb.spots()[2]);
    }

    @Test
    public void testSpiderSit() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.spiderSit(3);
    }

     @Test
    public void testAddBridge() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        // Act
        spiderWeb.addBridge("blue", 100, 2);        
        // Assert
        assertEquals("blue", spiderWeb.bridges()[0]); // Comprueba si el puente se agregó correctamente
    }

    @Test
    public void testRelocateBridge() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addBridge("red", 100, 2);
        // Act
        spiderWeb.relocateBridge("red", 150);
    }

    @Test
    public void testDelBridge() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        spiderWeb.addBridge("blue", 100, 2);
        // Act
        spiderWeb.delBridge("blue");
    }
}
