package pathfinding.PathFinders;


import pathfinding.DataStructures.HashSet;
import pathfinding.DataStructures.PriorityQueue;
import pathfinding.DataStructures.HashMap;
import pathfinding.DataStructures.ArrayList;
import pathfinding.DataStructures.Node;

public class AStar implements PathFinder {

    private char[][] map;
    public ArrayList<Node> rpath;
    
    public long aikaAlussa; 
    public long aikaLopussa;
    

    public AStar(char[][] map) {
        this.map = map;
        this.rpath = new ArrayList<>();
        aikaAlussa = 0; 
        aikaLopussa = 0; 
    }

    @Override
    public int find(Node start, Node end) {
        aikaAlussa = System.currentTimeMillis(); 
        //Nodes already evaluated
        HashSet<Node> closed = new HashSet<>();
        //Discovered nodes that have not been evaluated (initially only contains the start node)
        PriorityQueue<Node> open = new PriorityQueue<>();
        //Map containing the best path from one node to another
        HashMap<Node, Node> cameFrom = new HashMap<>();
        //The cost from the start to a node (initially all are infinity except start to start which is 0)
        HashMap<Node, Integer> startCost = new HashMap<>();
        //The cost from start to end, by passing a certain node (initially all are infinity except start that is estimated heuristically)
        HashMap<Node, Integer> endCost = new HashMap<>();
        //List containing all the neighbors to a node
        Node[][] nodes = new Node[map.length][map[0].length];
        
        initializeData(nodes, start, end, startCost, endCost, open);
        
        while (!open.isEmpty()) {
            Node current = open.poll();
            if (current.equal(end)) {
                reconstructPath(cameFrom, current, start);
                aikaLopussa = System.currentTimeMillis(); 
                return startCost.get(current);
            }

            closed.add(current);

            for (int i = 0; i < current.getNeighbors().size(); i++) {
                Node neighbor = current.getNeighbors().get(i);
                if (closed.contains(neighbor)) {     //Ignore already found nodes
                    continue;
                }

                if (!open.contains(neighbor)) {      //New node found
                    open.add(neighbor);
                }

                int estimatedScost = startCost.get(current) + neighbor.getCost();      //Cost from start to neighbor

                if (estimatedScost >= startCost.get(neighbor)) {
                    continue;       //This is not a better path
                }

                //This is path is better, so we add it to cameFrom
                cameFrom.put(neighbor, current);
                startCost.put(neighbor, estimatedScost);
                endCost.put(neighbor, startCost.get(neighbor) + ManhattanDistance(neighbor, end));
            }
        }
        aikaLopussa = System.currentTimeMillis();
        return -1;
    }
    /**
     * Initializes the data that is needed to perform the algorithm.
     * @param nodes A Node array that contains all the walkable nodes in the map.
     * @param start The start node.
     * @param end The end node.
     * @param startCost A hashmap that contains the cost from the start to a node.  
     * @param endCost A hashmap that contains the cost from start to end, by passing a certain node.
     * @param open A priorityqueue that contains the discovered nodes that have not been evaluated.
     */
    private void initializeData(Node[][] nodes, Node start, Node end, HashMap<Node,
        Integer> startCost, HashMap<Node, Integer> endCost, PriorityQueue<Node> open){
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == '@' || map[y][x] == 'O' || map[y][x] == 'T') {
                    continue;
                }
                Node current = new Node(x, y, 1);
                if(map[y][x] == 'W'){
                    current = new Node(x, y, 3);
                }
                nodes[y][x] = current;
                if (current.equal(start)) {
                    startCost.put(current, 0);
                    endCost.put(current, ManhattanDistance(current, end));
                    open.add(current);
                } else {
                    startCost.put(current, Integer.MAX_VALUE);      //Initialize Scost
                    endCost.put(current, Integer.MAX_VALUE);      //Initialize Ecost
                }
            }
        }

        // Adding to all nodes their neighbors
        for (int i = 0; i < startCost.set.size(); i++) {
            Node node = startCost.set.get(i);
            node = FindNeighbors(nodes, node);
        }
    }

    /**
     * Reconstructing the path. By using the cameFrom map, the method goes
     * backwards to reconstruct the path from start to end.
     *
     * @param cameFrom The map that contains the best path to a node
     * @param current The end node
     * @param start The start node
     * @return
     */
    public void reconstructPath(HashMap<Node, Node> cameFrom, Node current, Node start) {
        ArrayList<Node> path = new ArrayList<>();
        while (!current.equal(start)) {
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(start);
        path.reverse();
        this.rpath = path;
    }

    /**
     * Calculating Heuristic distance. By using ManhattanDistance(Taxicab
     * geometry) this method calculates the "shortest" distance from one node to another.
     *
     * @param a The start node
     * @param b The end node
     * @return
     */
    public int ManhattanDistance(Node a, Node b) {
        return (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()));
    }
    /**
     * Adds all neighbors to a node.
     * @param nodes A Node array that contains all the walkable nodes in the map. 
     * @param node The current node where neighbors will be added.
     * @return 
     */
    public Node FindNeighbors(Node[][] nodes, Node node){
        ArrayList<Node> l = new ArrayList<>();
        if (node.getY() != 0) {
            if ((nodes[node.getY() - 1][node.getX()]) != null) {
                l.add(nodes[node.getY() - 1][node.getX()]);
            }
        }
        if (node.getX() != map[0].length - 1) {
            if ((nodes[node.getY()][node.getX() + 1]) != null) {
                l.add(nodes[node.getY()][node.getX() + 1]);
            }
        }
        if (node.getY() != map.length - 1) {
            if ((nodes[node.getY() + 1][node.getX()]) != null) {
                l.add(nodes[node.getY() + 1][node.getX()]);
            }
        }
        if (node.getX() != 0) {
            if ((nodes[node.getY()][node.getX() - 1]) != null) {
                l.add(nodes[node.getY()][node.getX() - 1]);
            }
        }
        node.setNeighbors(l);
        return node;
    }

}
