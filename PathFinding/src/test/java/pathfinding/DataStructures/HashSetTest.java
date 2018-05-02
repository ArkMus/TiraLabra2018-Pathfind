
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
    
}
