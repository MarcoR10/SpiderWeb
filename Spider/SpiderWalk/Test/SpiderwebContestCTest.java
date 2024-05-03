package Test;
import org.junit.*;
import static org.junit.Assert.*;
import spiderweb.*;

public class SpiderwebContestCTest {

    @Test
    public void testSolveWithNoBridges() {
        // Arrange
        int strands = 5;
        int favorite = 3;
        int[][] bridgeInfo = new int[0][0];
        SpiderWebContest solver = new SpiderWebContest();
        // Act
        int[] result = solver.solve(strands, favorite, bridgeInfo);
        // Assert
        assertArrayEquals(new int[]{0, 1, 1, 0, 1}, result);
    }

    @Test
    public void testSolveWithBridges() {
        // Arrange
        int strands = 5;
        int favorite = 3;
        int[][] bridgeInfo = {{50, 2}, {60, 3}};
        SpiderWebContest solver = new SpiderWebContest();
        // Act
        int[] result = solver.solve(strands, favorite, bridgeInfo);
        // Assert
        assertArrayEquals(new int[]{2, 1, 0, 1, 2}, result);
    }

    @Test
    public void testSimulate() {
        // Arrange
        int strands = 5;
        int favorite = 3;
        int[][] bridges = {{50, 2}, {60, 3}};
        int strand = 2;
        SpiderWebContest simulator = new SpiderWebContest();
        // Act & Assert
        simulator.simulate(strands, favorite, bridges, strand);
    }

}
