
package pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStar {
    
    private int[][] map;

    public AStar(int[][] map) {
        this.map = map;
    }
    
    /**
     * The find method
     * @param start The node where the search starts from
     * @param end The node that is the destination
     * @return 
     */
    public int find (Node start, Node end){
        //Nodes already evaluated
        HashSet<Node> closed = new HashSet<>();
        //Discovered nodes that have not been evaluated (initially only contains the start node)
        PriorityQueue<Node> open = new PriorityQueue<>();
        //Map containing the best path from one node to another
        HashMap<Node, Node> cameFrom = new HashMap<>();
        //The cost from the start to a node (initially all are infinity except start to start which is 0)
        HashMap<Node, Integer> Scost = new HashMap<>();
        //The cost from start to end, by passing a certain node (initially all are infinity except start that is estimated heuristically)
        HashMap<Node, Integer> Ecost = new HashMap<>();
        //List containing all the neighbors to a node
        Node[][] nodes = new Node[map.length][map[0].length];
        //TODO add to all nodes their neighbors
        for (int y = 0; y < map.length; y++){
            for (int x = 0; x < map[0].length; x++) {                
                Node current = new Node(x, y, 1);
                nodes[y][x] = current;
                if (current.equal(start)){
                    Scost.put(current, 0);
                    Ecost.put(current, ManhattanDistance(current, end));
                    open.add(current);
                }else{
                    Scost.put(current, Integer.MAX_VALUE);      //Initialize Scost
                    Ecost.put(current, Integer.MAX_VALUE);      //Initialize Ecost
                }
            }
        }
        
        for(Node n : Scost.keySet()){
            if(n.getY() != 0){
                n.setUp(nodes[n.getY()-1][n.getX()]);
            }
            if(n.getX() != map[0].length-1){
                n.setRight(nodes[n.getY()][n.getX()+1]);
            }
            if(n.getY() != map.length-1){
                n.setDown(nodes[n.getY()+1][n.getX()]);
            }
            if(n.getX() != 0){
                n.setLeft(nodes[n.getY()][n.getX()-1]);
            }
        }

        while(!open.isEmpty()){
            Node current = open.poll();
            if(current.equal(end)){
                System.out.println("The shortest path is: " + reconstructPath(cameFrom, current, start));
                return Scost.get(current);
            }
            
            closed.add(current);
            
            ArrayList<Node> neighbors = new ArrayList<>();
            if(current.getUp() != null){
                neighbors.add(current.getUp());
            }
            if(current.getRight()!= null){
                neighbors.add(current.getRight());
            }
            if(current.getDown()!= null){
                neighbors.add(current.getDown());
            }
            if(current.getLeft()!= null){
                neighbors.add(current.getLeft());
            }
            
            for (Node n : neighbors){
                if(closed.contains(n)){     //Ignore already found nodes
                    continue;
                }
                
                if(!open.contains(n)){      //New node found
                    open.add(n);
                }
                
                int estimatedScost = Scost.get(current) + n.getCost();      //Cost from start to neighbor
                
                if (estimatedScost >= Scost.get(n)){
                    continue;       //This is not a better path
                }
                
                //This is path is better, so we add it to cameFrom
                cameFrom.put(n, current);
                Scost.put(n, estimatedScost);
                Ecost.put(n, Scost.get(n) + ManhattanDistance(n, end));
            }
        }
        
        return -1;
    }
    
    public ArrayList<Node> reconstructPath(HashMap<Node, Node> cameFrom, Node current, Node start){
        ArrayList<Node> path = new ArrayList<>();
        while(!current.equal(start)){
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }
    
    public int ManhattanDistance(Node a, Node b){
        return (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()));
    }
    
    
}
