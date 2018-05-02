/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding.DataStructures;

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
public class ArrayListTest {
    ArrayList<Integer> al;
    public ArrayListTest() {
    }

    @Before
    public void setUp() {
        al = new ArrayList<>();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ArrayList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        al.add(1);
        Integer a = 1;
        assertEquals(a, al.get(0));
    }

    /**
     * Test of get method, of class ArrayList.
     */
    @Test 
    public void testGet() {
        System.out.println("get");
        al.add(1);
        al.add(8);
        Integer a = 1;
        Integer b = 8;
        assertEquals(a, al.get(0));
        assertEquals(b, al.get(1));
        
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsInGet() {
        System.out.println("get");
        al.add(1);
        al.get(5);
    }

    /**
     * Test of reverse method, of class ArrayList.
     */
    @Test
    public void testReverse() {
        System.out.println("reverse");
        al.add(1);
        al.add(2);
        al.add(3);
        ArrayList<Integer> rl = new ArrayList<>();
        rl.add(3);
        rl.add(2);
        rl.add(1);
        al.reverse();
        assertEquals(rl.get(0), al.get(0));
        assertEquals(rl.get(1), al.get(1));
        assertEquals(rl.get(2), al.get(2));
    }

    /**
     * Test of size method, of class ArrayList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        al.add(1);
        assertEquals(1, al.size());
    }
    
}
