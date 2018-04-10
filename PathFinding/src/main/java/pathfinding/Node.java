
package pathfinding;

import java.util.ArrayList;

public class Node implements Comparable<Node>{
    private int x;
    private int y;
    private int cost;
    private ArrayList<Node> neighbors;

    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Node> neighbors) {
        this.neighbors = neighbors;
    }
    
    /**
     * Initialize node.
     * @param x X Coordinate
     * @param y Y Coordinate
     * @param cost The cost to a node
     */
    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        if (o.cost > this.cost) {
            return -1;
        } else {
            return 1;
        }
    }    
    /**
     * Are two nodes equal?. Testing if two nodes are equal on the basis of 
     * their x and y coordinates.
     * @param o the node that is being compared to.
     * @return 
     */
    public boolean equal(Node o){
        if(this.x == o.getX() && this.y == o.getY()){
            return true;
        }else{
            return false;
        }
    }
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
    
    
}
