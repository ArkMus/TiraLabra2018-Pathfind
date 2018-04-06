
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
public class Map_readerTest {
    
    public Map_readerTest() {
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
     * Test of generateMap method, of class Map_reader.
     */
    @Test
    public void testGenerateMap() {
        System.out.println("generateMap");
        Map_reader tmr = new Map_reader("/home/markusan/uniprojects/TiraLab/TiraLabra2018-Pathfind/PathFinding/src/test/java/pathfinding/test2.map");
        char[][] expResult = {
        {'.','.','.'},
        {'.','.','.'},
        {'.','.','.'}};
        char[][] result = tmr.generateMap();
        assertArrayEquals(expResult, result);
    }
    
}
