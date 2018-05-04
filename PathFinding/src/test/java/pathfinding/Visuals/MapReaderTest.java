/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding.Visuals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author markusan
 */
public class MapReaderTest {
    
    public MapReaderTest() {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateMap method, of class MapReader.
     */
    @Test
    public void testGenerateMap() {
        System.out.println("generateMap");
        MapReader tmr = new MapReader("src/test/java/pathfinding/test2.map");
        MapReader tmr2 = new MapReader("");
        char[][] expResult = {
        {'.','.','.'},
        {'.','.','.'},
        {'.','.','.'}};
        char[][] expResult2 = new char[1][1];
        char[][] result = tmr.generateMap();
        char[][] result2 = tmr2.generateMap();
        assertArrayEquals(expResult, result);
        assertArrayEquals(expResult2, result2);
    }
    
}
