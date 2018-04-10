package pathfinding;

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
public class NodeTest {
    
    public NodeTest() {
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
     * Test of compareTo method, of class Node.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Node tNode = new Node(1, 2, 3);
        Node tNode2 = new Node(1, 2, 4);
        assertEquals(-1, tNode.compareTo(tNode2));
        assertEquals(1, tNode2.compareTo(tNode));
    }

    /**
     * Test of equal method, of class Node.
     */
    @Test
    public void testEqual() {
        System.out.println("equal");
        Node tNode = new Node(1, 2, 3);
        Node tNode2 = new Node(1, 2, 3);
        Node tNode3 = new Node(2, 3, 5);
        assertTrue(tNode.equal(tNode2));
        assertTrue(!(tNode.equal(tNode3)));
    }

    /**
     * Test of getX method, of class Node.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Node tNode = new Node(1, 2, 3);
        assertEquals(1, tNode.getX());
    }

    /**
     * Test of getY method, of class Node.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Node tNode = new Node(1, 2, 3);
        assertEquals(2, tNode.getY());
    }

    /**
     * Test of getCost method, of class Node.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        Node tNode = new Node(1, 2, 3);
        assertEquals(3, tNode.getCost());
    }

    /**
     * Test of toString method, of class Node.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Node tNode = new Node(1, 2, 3);
        String expected = "(" + tNode.getX() + ", " + tNode.getY() + ")";
        assertEquals(expected, tNode.toString());
    }
    
}
