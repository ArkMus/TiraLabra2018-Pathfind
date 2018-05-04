
package pathfinding.PathFinders;

import pathfinding.DataStructures.Node;
import pathfinding.PathFinders.AStar;
import pathfinding.DataStructures.ArrayList;
import pathfinding.DataStructures.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pathfinding.Visuals.MapReader;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author markusan
 */
public class AStarTest {
    
    public AStarTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class AStar.
     */
    @Test
    public void testFind() {
        MapReader mp = new MapReader("src/test/java/pathfinding/test.map");
        char[][] map = mp.generateMap();
        AStar ASTAR = new AStar(map);
        Node start = new Node(0, 6, 1);
        Node end = new Node(6, 0, 1);
        int anwser = ASTAR.find(start, end);
        
        MapReader mp2 = new MapReader("src/test/java/pathfinding/wall.map");
        char[][] map2 = mp2.generateMap();
        AStar ASTAR2 = new AStar(map2);
        int anwser2 = ASTAR2.find(start, end);
        
        assertEquals(12, anwser);
        assertEquals(-1, anwser2);
    }

    /**
     * Test of reconstructPath method, of class AStar.
     */
    @Test
    public void testReconstructPath() {
        MapReader mp = new MapReader("/home/markusan/uniprojects/TiraLab/TiraLabra2018-Pathfind/PathFinding/src/test/java/pathfinding/test2.map");
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
     * Test of ManhattanDistance method, of class AStar.
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
        assertEquals(4, tstar.ManhattanDistance(a1, b1));     //7-4 = 3 ,  4-3 = 1 ,   3 + 1 = 4 
    }
    
}
 