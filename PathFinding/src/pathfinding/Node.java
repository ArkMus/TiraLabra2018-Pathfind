
package pathfinding;

public class Node implements Comparable<Node>{
    private int x;
    private int y;
    private int cost;
    private Node up;
    private Node right;
    private Node down;
    private Node left;

    public Node getUp() {
        return up;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

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
