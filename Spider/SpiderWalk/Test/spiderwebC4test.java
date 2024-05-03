package Test;


import spiderweb.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * The test class spiderwebC4test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class spiderwebC4test{
   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   private final PrintStream originalOut = System.out;

   @BeforeEach 
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

   @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

   @Test
    public void testNormalBridgeMakeInvisible() throws SpiderException {
        Normal normalBridge = new Normal(100, 100, 200, 200, "red", 1);
        try{
            normalBridge.makeInvisible();
        }catch (Exception e){
            throw new SpiderException(SpiderException.NO_EXITEN_PUENTES);
        }
    }

   @Test
    public void testFixedBridgeMakeInvisible() throws SpiderException {
        Fixed fixedBridge = new Fixed(100, 100, 200, 200, "blue", 2);
        try{
            fixedBridge.makeInvisible();
        }catch (Exception e){
            throw new SpiderException(SpiderException.NO_EXITEN_PUENTES);
        }
    }

   @Test
    public void testBridgeMarkAsUsed() throws SpiderException{
        // Arrange
        Bridge bridge = new Normal(100, 100, 200, 200, "yellow", 3);
        // Act
        bridge.markAsUsed();
        // Assert
        assertTrue(bridge.isUsed());
    }

}
