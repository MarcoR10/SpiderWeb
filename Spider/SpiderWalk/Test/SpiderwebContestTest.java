package Test;

import spiderweb.*;
import static org.junit.Assert.*;
import org.junit.*;

public class SpiderwebContestTest {

    @Test
    public void testAddStrand() {
        // Arrange
        SpiderWeb spiderWeb = new SpiderWeb(5, 300);
        int initialStrandCount = spiderWeb.totalStrand.size();
        
        // Act
        spiderWeb.addStrand();
        
        // Assert
        assertEquals(initialStrandCount + 1, spiderWeb.totalStrand.size());
    }


}
