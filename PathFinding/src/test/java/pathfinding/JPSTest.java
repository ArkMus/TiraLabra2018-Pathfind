
package pathfinding;

import pathfinding.DataStructures.Node;
import pathfinding.PathFinders.AStar;
import pathfinding.PathFinders.JPS;
import pathfinding.DataStructures.ArrayList;
import pathfinding.DataStructures.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author markusan
 */
public class JPSTest {
    
    public JPSTest() {
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
        MapReader mp = new MapReader("src/test/java/pathfinding/test.map");
        char[][] map = mp.generateMap();
        JPS jps1 = new JPS(map);
        Node start = new Node(0, 6, 1);
        Node end = new Node(6, 0, 1);
        int anwser = jps1.find(start, end);
        
        MapReader mp2 = new MapReader("src/test/java/pathfinding/wall.map");
        char[][] map2 = mp2.generateMap();
        JPS jps2 = new JPS(map2);
        int anwser2 = jps2.find(start, end);
        
        assertEquals(12, anwser);
        assertEquals(-1, anwser2);
    }

    /**
     * Test of isWalkable method, of class JPS.
     */
    @Test
    public void testIsWalkable() {
        System.out.println("isWalkable");
        int x = 0;
        int y = 0;
        Node[][] nodes = new Node[5][5];
        nodes[0][0] = new Node(x, y, 1);
        char[][] map = {{}};
        JPS instance = new JPS(map);
        boolean result = instance.isWalkable(x, y, nodes);
        boolean result2 = instance.isWalkable(1, 1, nodes);
        assertEquals(true, result);
        assertEquals(false, result2);
    }

    /**
     * Test of reconstructPath method, of class JPS.
     */
    @Test
    public void testReconstructPath() {
        System.out.println("reconstructPath");
        MapReader mp = new MapReader("src/test/java/pathfinding/test2.map");
        char[][] map = mp.generateMap();
        AStar tstar = new AStar(map);
        Node start = new Node(0, 0, 1);
        Node end = new Node(2, 2, 1);
        ArrayList<Node> tpath = new ArrayList();
        HashMap<Node, Node> cameFrom = new HashMap<>();
        
        Node n2 = new Node(0, 1, 0);
        Node n3 = new Node(0, 2, 0);
        Node n4 = new Node(1, 2, 0);
        
        
        cameFrom.put(end, n4);
        cameFrom.put(n4, n3);
        cameFrom.put(n3, n2);
        cameFrom.put(n2, start);
        
        
        tpath.add(start);
        tpath.add(n2);
        tpath.add(n3);
        tpath.add(n4);
        tpath.add(end);
        
        tstar.reconstructPath(cameFrom, end, start);
        assertEquals(tpath.get(0), tstar.rpath.get(0));
        assertEquals(tpath.get(1), tstar.rpath.get(1));
        assertEquals(tpath.get(2), tstar.rpath.get(2));
        assertEquals(tpath.get(3), tstar.rpath.get(3));
        assertEquals(tpath.get(4), tstar.rpath.get(4));
    }

    /**
     * Test of ManhattanDistance method, of class JPS.
     */
    @Test
    public void testManhattanDistance() {
        System.out.println("ManhattanDistance");
        char[][] map = {{}};
        AStar tstar = new AStar(map);
        Node a = new Node(4, 3, 1);
        Node b = new Node(7, 4, 1);
        Node a1 = new Node(7, 4, 1);
        Node b1 = new Node(4, 3, 1);
        assertEquals(4, tstar.ManhattanDistance(a, b));     //4-7 = -3 ,  3-4 = -1 ,   |-3| + |-1| = 4 
        assertEquals(4, tstar.ManhattanDistance(a, b));     //7-4 = 3 ,  4-3 = 1 ,   3 + 1 = 4 
    }

    /**
     * Test of FindNeighbors method, of class JPS.
     */
    @Test
    public void testFindNeighbors() {
        System.out.println("FindNeighbors");
        HashMap<Node, Node> cameFrom = new HashMap<>();
        Node[][] nodes = {
        {new Node(0, 0, 0), new Node(1, 0, 0), new Node(0, 0, 0)},
        {new Node(0, 4, 0), new Node(0, 0, 0), new Node(2, 0, 0)},
        {new Node(0, 0, 0), new Node(0, 3, 0), new Node(0, 0, 0)}};
        char[][] map = new char[3][3];
        JPS instance = new JPS(map);
        Node expResult = new Node(0, 0, 0);
        ArrayList<Node> l = new ArrayList<>();
        l.add(nodes[0][1]);
        l.add(nodes[2][1]);
        expResult.setNeighbors(l);
        Node result = instance.FindNeighbors(nodes[1][1], cameFrom, nodes);
        
        assertEquals(expResult.getNeighbors().get(0), result.getNeighbors().get(0));
    }

    /**
     * Test of Jump method, of class JPS.
     */
    @Test
    public void testJump() {
        System.out.println("Jump");
        Node current = new Node(0, 0, 0);
        Node end = new Node(2, 2, 0);
        Node[][] nodes = {
        {new Node(0, 0, 0), new Node(1, 0, 0), new Node(2, 0, 0)},
        {new Node(1, 0, 0), new Node(1, 1, 0), new Node(1, 2, 0)},
        {new Node(2, 0, 0), new Node(2, 1, 0), new Node(2, 2, 0)}};
        char[][] map = new char[3][3];
        JPS instance = new JPS(map);
        Node result1 = instance.Jump(1, 1, current, end, nodes);
        System.out.println("1 " + result1);
        assertEquals(true, result1.equal(end));
    }

    /**
     * Test of identifySuccessors method, of class JPS.
     */
    @Test
    public void testIdentifySuccessors() {
        //TODO Make a test for this
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
//        instance.identifySuccessors(current, end, open, closed, nodes, cameFrom, Scost, Ecost);
        assertEquals(true, true);
    }
    
}
