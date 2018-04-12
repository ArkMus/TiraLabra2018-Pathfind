
package pathfinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author markusan
 */
public class JPSTest {
    
    public JPSTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class JPS.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Node start = null;
        Node end = null;
        JPS instance = null;
        int expResult = 0;
        int result = instance.find(start, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isWalkable method, of class JPS.
     */
    @Test
    public void testIsWalkable() {
        System.out.println("isWalkable");
        int x = 0;
        int y = 0;
        Node[][] nodes = null;
        JPS instance = null;
        boolean expResult = false;
        boolean result = instance.isWalkable(x, y, nodes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reconstructPath method, of class JPS.
     */
    @Test
    public void testReconstructPath() {
        System.out.println("reconstructPath");
        HashMap<Node, Node> cameFrom = null;
        Node current = null;
        Node start = null;
        JPS instance = null;
        ArrayList<Node> expResult = null;
        ArrayList<Node> result = instance.reconstructPath(cameFrom, current, start);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ManhattanDistance method, of class JPS.
     */
    @Test
    public void testManhattanDistance() {
        System.out.println("ManhattanDistance");
        Node a = null;
        Node b = null;
        JPS instance = null;
        int expResult = 0;
        int result = instance.ManhattanDistance(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FindNeighbors method, of class JPS.
     */
    @Test
    public void testFindNeighbors() {
        System.out.println("FindNeighbors");
        Node n = null;
        HashMap<Node, Node> cameFrom = null;
        Node[][] nodes = null;
        JPS instance = null;
        Node expResult = null;
        Node result = instance.FindNeighbors(n, cameFrom, nodes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Jump method, of class JPS.
     */
    @Test
    public void testJump() {
        System.out.println("Jump");
        int NeighborY = 0;
        int NeighborX = 0;
        Node current = null;
        Node end = null;
        Node[][] nodes = null;
        JPS instance = null;
        Node expResult = null;
        Node result = instance.Jump(NeighborY, NeighborX, current, end, nodes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of identifySuccessors method, of class JPS.
     */
    @Test
    public void testIdentifySuccessors() {
        System.out.println("identifySuccessors");
        Node current = null;
        Node end = null;
        PriorityQueue<Node> open = null;
        HashSet<Node> closed = null;
        Node[][] nodes = null;
        HashMap<Node, Node> cameFrom = null;
        HashMap<Node, Integer> Scost = null;
        HashMap<Node, Integer> Ecost = null;
        JPS instance = null;
        instance.identifySuccessors(current, end, open, closed, nodes, cameFrom, Scost, Ecost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
