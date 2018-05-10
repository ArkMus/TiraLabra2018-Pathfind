
package pathfinding.DataStructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author markusan
 */
public class HashSetTest {
    HashSet<Integer> set;
    public HashSetTest() {
    }

    @Before
    public void setUp() {
        set = new HashSet<>();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add and contains method, of class HashSet.
     */
    @Test
    public void testAddAndContains() {
        System.out.println("addContains");
        assertEquals(false, set.contains(1));
        set.add(1);
        assertEquals(true, set.contains(1));   
    }
    
    @Test
    public void testEmptySet() {
        System.out.println("testEmptySet");
        assertEquals(false, set.contains(1));
    }
    
    @Test
    public void testMultiple() {
        System.out.println("testMultiple");
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(true, set.contains(1));
        assertEquals(true, set.contains(2));
        assertEquals(true, set.contains(3));
    }
    
    @Test
    public void addNull() {
        set.add(null);
        assertEquals(false, set.contains(1));
    }
    
    @Test
    public void addSameElement() {
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(5);
        assertEquals(true, set.contains(1));
    }
    
    @Test
    public void testToString() {
        set.add(1);
        set.add(2);
        assertEquals("{1, 2}", set.toString());
    }
    
    
}
