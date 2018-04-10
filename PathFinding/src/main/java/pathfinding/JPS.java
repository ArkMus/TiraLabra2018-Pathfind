package pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class JPS {

    private char[][] map;

    public JPS(char[][] map) {
        this.map = map;
    }

    /**
     * The main algorithm. First it initializes all nodes and neighbors. Then
     * does A* logic (template provided by wikipedia).
     *
     * @param start The node where the search starts from
     * @param end The node that is the destination
     * @return
     */
    public int find(Node start, Node end) {
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

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == '@' || map[y][x] == 'O' || map[y][x] == 'T') {
                    continue;
                }

                Node current = new Node(x, y, 1);
                nodes[y][x] = current;
                if (current.equal(start)) {
                    Scost.put(current, 0);
                    Ecost.put(current, ManhattanDistance(current, end));
                    open.add(current);
                } else {
                    Scost.put(current, Integer.MAX_VALUE);      //Initialize Scost
                    Ecost.put(current, Integer.MAX_VALUE);      //Initialize Ecost
                }
            }
        }

        // Adding to all nodes their neighbors
        for (Node n : Scost.keySet()) {
            Node l = FindNeighbors(n, cameFrom, nodes);
            n = l;
        }

        while (!open.isEmpty()) {
            Node current = open.poll();

            if (current.equal(end)) {
                System.out.println("The shortest path is: " + reconstructPath(cameFrom, current, start));
                return Scost.get(current);
            }

            closed.add(current);
            //Add all nodes that will possibly be searched
            identifySuccessors(current, end, open, closed, nodes, cameFrom, Scost, Ecost);

        }

        return -1;
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
    public ArrayList<Node> reconstructPath(HashMap<Node, Node> cameFrom, Node current, Node start) {
        ArrayList<Node> path = new ArrayList<>();
        while (!current.equal(start)) {
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }

    /**
     * Calculating Heuristic distance. By using the ManhattanDistance(Taxicab
     * geometry) calculates the "shortest" distance from one node to another.
     *
     * @param a The start node
     * @param b The end node
     * @return
     */
    public int ManhattanDistance(Node a, Node b) {
        return (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()));
    }

    /**
     * Finding the neighbors. Finds neighbors to the node, but ignores those
     * that are not optimal.
     *
     * @param n
     * @param cameFrom
     * @param nodes
     * @return
     */
    public Node FindNeighbors(Node n, HashMap<Node, Node> cameFrom, Node[][] nodes) {
        Node parent = cameFrom.get(n);
        ArrayList<Node> l = new ArrayList<>();

        //Pruning: avoid adding neighbors that are not optimal
        if (parent != null) {
            int x = n.getX();
            int y = n.getY();

            //Get the direction
            int dx = ((x - parent.getX()) / Math.max(Math.abs(x - parent.getX()), 1));
            int dy = ((y - parent.getY()) / Math.max(Math.abs(y - parent.getY()), 1));

            if (dx != 0) {
                if (nodes[y][x + dx] != null) {
                    l.add(nodes[y][x + dx]);
                }
                if (nodes[y + 1][x] != null) {
                    l.add(nodes[y + 1][x]);
                }
                if (nodes[y - 1][x] != null) {
                    l.add(nodes[y - 1][x]);
                }
            } else if (dy != 0) {
                if (nodes[y + dy][x] != null) {
                    l.add(nodes[y + dy][x]);
                }
                if (nodes[y][x + 1] != null) {
                    l.add(nodes[y][x + 1]);
                }
                if (nodes[y][x - 1] != null) {
                    l.add(nodes[y][x - 1]);
                }
            }

            //If the node has no parents, add all neighbors
        } else {
            if (n.getY() != 0) {
                if ((nodes[n.getY() - 1][n.getX()]) != null) {
                    l.add(nodes[n.getY() - 1][n.getX()]);
                }
            }
            if (n.getX() != map[0].length - 1) {
                if ((nodes[n.getY()][n.getX() + 1]) != null) {
                    l.add(nodes[n.getY()][n.getX() + 1]);
                }
            }
            if (n.getY() != map.length - 1) {
                if ((nodes[n.getY() + 1][n.getX()]) != null) {
                    l.add(nodes[n.getY() + 1][n.getX()]);
                }
            }
            if (n.getX() != 0) {
                if ((nodes[n.getY()][n.getX() - 1]) != null) {
                    l.add(nodes[n.getY()][n.getX() - 1]);
                }
            }
        }
        n.setNeighbors(l);
        return n;
    }

    /**
     * Jumps over nodes to improve performance. The algorithm will keep skipping
     * nodes until it either finds the end, if the next node is out of bounds/an
     * obstacle or if the next node has forced neighbors.
     *
     * @param neighbor
     * @param current
     * @param end
     * @param nodes
     * @return
     */
    public Node Jump(Node neighbor, Node current, Node end, Node[][] nodes) {
        if (neighbor == end) {
            return neighbor;
        }

        //Get the direction
        int dx = neighbor.getX() - current.getX();
        int dy = neighbor.getY() - current.getY();

        //Checks for forced neighbors
        //Checks horizontally and vertically
        if (neighbor.getX() + 1 != nodes[0].length
                && neighbor.getY() + 1 != nodes.length
                && neighbor.getX() - 1 != -1
                && neighbor.getY() - 1 != -1) {

            if (dx != 0) {
                if ((nodes[neighbor.getY() + 1][neighbor.getX()] != null && nodes[neighbor.getY() + 1][neighbor.getX() - dx] == null)
                        || ((nodes[neighbor.getY() - 1][neighbor.getX()] != null) && nodes[neighbor.getY() - 1][neighbor.getX() - dx] == null)) {
                    return neighbor;
                }
            } else if (dy != 0) {
                if ((nodes[neighbor.getY()][neighbor.getX() + 1] != null && nodes[neighbor.getY() - dy][neighbor.getX() + 1] == null)
                        || ((nodes[neighbor.getY()][neighbor.getX() - 1] != null) && nodes[neighbor.getY() - dy][neighbor.getX() - 1] == null)) {
                    return neighbor;
                }
                // when moving vertically check for horizontal jump points
                if (Jump(nodes[neighbor.getY()][neighbor.getX() + 1], neighbor, end, nodes) != null
                        || Jump(nodes[neighbor.getY()][neighbor.getX() - 1], neighbor, end, nodes) != null) {
                    return neighbor;
                }
            } else {
                return null;
            }
        }

        if (neighbor.getX() + 1 != nodes[0].length
                && neighbor.getY() + 1 != nodes.length
                && neighbor.getX() - 1 != -1
                && neighbor.getY() - 1 != -1) {
            return Jump(nodes[neighbor.getY() + dy][neighbor.getX() + dx], neighbor, end, nodes);
        }
        return null;
    }

    public void identifySuccessors(Node current, Node end, PriorityQueue<Node> open, HashSet<Node> closed, Node[][] nodes,
            HashMap<Node, Node> cameFrom, HashMap<Node, Integer> Scost, HashMap<Node, Integer> Ecost) {

        int ed = 0; //Estimated distance
        int ds = 0; // Distance to end

        for (Node n : current.getNeighbors()) {
            Node jnode = Jump(n, current, end, nodes);

            if (jnode == null || closed.contains(jnode)) {
                continue;
            }

            ed = ManhattanDistance(jnode, current);
            ds = Scost.get(current) + ed;

            //If this node hasn't been opened, open it.
            //If it has been opened, but it is better, update it.
            if (!open.contains(jnode) || ds < Scost.get(jnode)) {
                Scost.put(jnode, ds);
                Ecost.put(jnode, Scost.get(jnode) + ManhattanDistance(jnode, end));
                cameFrom.put(jnode, current);

                if (!open.contains(jnode)) {
                    open.add(jnode);
                }
            }
        }

    }

}
