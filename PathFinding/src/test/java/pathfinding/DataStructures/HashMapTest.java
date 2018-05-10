/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding.DataStructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author markusan
 */
public class HashMapTest {
    HashMap<Integer, String> map;
    public HashMapTest() {
    }
    
    @Before
    public void setUp() {
        map = new HashMap<>();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of put and get method, of class HashMap.
     */
    @Test
    public void testPutAndGet() {
        System.out.println("put");
        map.put(1, "Hello");
        map.put(74, "World");
        assertEquals("Hello", map.get(1));
        assertEquals("World", map.get(74));
    }
    
    @Test
    public void getNonexistingKey() {
        System.out.println("getNonexistingKey");
        assertEquals(null, map.get(1));
    }
    
    @Test
    public void testToString() {
        map.put(1, "hi");
        map.put(2, "yo");
        assertEquals("{1=hi, 2=yo}", map.toString());
    }
    
}
