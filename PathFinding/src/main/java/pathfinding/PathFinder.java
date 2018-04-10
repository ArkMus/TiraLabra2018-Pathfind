/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

/**
 *
 * @author markusan
 */
public interface PathFinder {
    
    /**
     * The main algorithm. First it initializes all nodes and neighbors. Then
     * does A* logic (template provided by wikipedia).
     *
     * @param start The node where the search starts from
     * @param end The node that is the destination
     * @return
     */
    public int find(Node start, Node end);
}
