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
     * Test of getUp method, of class Node.
     */
    
    @Test
    public void testGetUp() {
        System.out.println("getUp");
        Node tNode = new Node(1, 2, 3);
        Node tNode2 = new Node(1, 2, 4);
        tNode.setUp(tNode2);
        assertEquals(tNode2, tNode.getUp());
    }

    /**
     * Test of setUp method, of class Node.
     */
    @Test
    public void testSetUp() {
        System.out.println("setUp");
        Node tNode = new Node(1, 2, 3);
        Node tNode2 = new Node(1, 2, 4);
        tNode.setUp(tNode2);
        assertEquals(tNode2, tNode.getUp());
    }

    /**
     * Test of getRight method, of class Node.
     */
    @Test
    public void testGetRight() {
        System.out.println("getRight");
        Node tNode = new Node(1, 2, 3);
        Node tNode2 = new Node(1, 2, 4);
        tNode.setRight(tNode2);
        assertEquals(tNode2, tNode.getRight());
    }

    /**
     * Test of setRight method, of class Node.
     */
    @Test
    public void testSetRight() {
        System.out.println("setRight");
        Node tNode = new Node(1, 2, 3);
        Node tNode2 = new Node(1, 2, 4);
        tNode.setRight(tNode2);
        assertEquals(tNode2, tNode.getRight());
    }

    /**
     * Test of getDown method, of class Node.
     */
    @Test
    public void testGetDown() {
        System.out.println("getDown");
        Node tNode = new Node(1, 2, 3);
        Node tNode2 = new Node(1, 2, 4);
        tNode.setDown(tNode2);
        assertEquals(tNode2, tNode.getDown());
    }

    /**
     * Test of setDown method, of class Node.
     */
    @Test
    public void testSetDown() {
        System.out.println("setDown");
        Node tNode = new Node(1, 2, 3);
        Node tNode2 = new Node(1, 2, 4);
        tNode.setDown(tNode2);
        assertEquals(tNode2, tNode.getDown());
    }

    /**
     * Test of getLeft method, of class Node.
     */
    @Test
    public void testGetLeft() {
        System.out.println("getLeft");
        Node tNode = new Node(1, 2, 3);
        Node tNode2 = new Node(1, 2, 4);
        tNode.setLeft(tNode2);
        assertEquals(tNode2, tNode.getLeft());
    }

    /**
     * Test of setLeft method, of class Node.
     */
    @Test
    public void testSetLeft() {
        System.out.println("setLeft");
        Node tNode = new Node(1, 2, 3);
        Node tNode2 = new Node(1, 2, 4);
        tNode.setLeft(tNode2);
        assertEquals(tNode2, tNode.getLeft());
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
