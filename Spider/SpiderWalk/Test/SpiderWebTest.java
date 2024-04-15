package Test;

import spiderweb.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Point;

public class SpiderWebTest {

    private SpiderWeb spiderWeb;

    @Before
    public void setUp() {
        spiderWeb = new SpiderWeb(5, 300);
    }

    @Test
    public void testAddBridge() {
        spiderWeb.addBridge("red", 50, 2);
        assertNotNull(spiderWeb.bridges());
        assertEquals(1, spiderWeb.bridges().length);
        assertEquals("red", spiderWeb.bridges()[0]);
    }

    @Test
    public void testAddStrand() {
        spiderWeb.addStrand();
        assertEquals(6, spiderWeb.totalStrand.size());
    }

    @Test
    public void testAddSpot() {
        spiderWeb.addSpot("yellow", 3);
        assertEquals("yellow", spiderWeb.spots().length > 0 ? spiderWeb.spots()[0] : "");
    }

    @Test
    public void testDelSpot() {
        spiderWeb.addSpot("green", 3);
        spiderWeb.delSpot("green");
        assertEquals(0, spiderWeb.spots().length);
    }

    @Test
    public void testSpiderLasthPath() {
        assertNull(spiderWeb.spiderLasthPath());
        spiderWeb.spiderSit(3);
        spiderWeb.spiderWalk(true);
    }

    @Test
    public void testReachableSpots() {
        assertNotNull(spiderWeb.reachableSpots());
    }

    @Test
    public void testUnusedBridges() {
        assertNotNull(spiderWeb.unusedBridges());
    }

}