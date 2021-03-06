/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding.PathFinders;

import pathfinding.DataStructures.HashMap;
import pathfinding.DataStructures.Node;

/**
 *
 * @author markusan
 */
public interface PathFinder {
    
    /**
     * The main algorithm. First it initializes all nodes and neighbors. Then it
     * does pathfinding logic. The method will stop when it finds the goal node,
     * or if it fails to find the goal node.
     *
     * @param start The node where the search starts from
     * @param end The node that is the destination
     * @return
     */
    public int find(Node start, Node end);
    
    public int ManhattanDistance(Node a, Node b);
    
}
