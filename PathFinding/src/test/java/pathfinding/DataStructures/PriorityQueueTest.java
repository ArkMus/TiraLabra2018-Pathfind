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
public class PriorityQueueTest {
    
    public PriorityQueueTest() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
    }

    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class PriorityQueue.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        assertEquals(false, pq.isEmpty());
        
    }

    /**
     * Test of poll method, of class PriorityQueue.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node q = new Node(3, 0, 3);
        Node w = new Node(1, 1, 1);
        Node e = new Node(2, 0, 2);
        pq.add(q);
        pq.add(w);
        pq.add(e);
        assertEquals(1, pq.poll().getCost());
        assertEquals(2, pq.poll().getCost());
        assertEquals(3, pq.poll().getCost());
    }

    /**
     * Test of contains method, of class PriorityQueue.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node w = new Node(1, 1, 1);
        pq.add(w);
        assertEquals(true, pq.contains(new Node(1, 1, 1)));
        assertEquals(false, pq.contains(new Node(1, 7, 1)));
    }

    /**
     * Test of isEmpty method, of class PriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PriorityQueue<Node> pq = new PriorityQueue<>();
        assertEquals(true, pq.isEmpty());
        pq.add(new Node(0, 0, 0));
        assertEquals(false, pq.isEmpty());
    }
    
}
