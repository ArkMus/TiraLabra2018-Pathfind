
package pathfinding.Visuals;

import pathfinding.DataStructures.Node;
import pathfinding.DataStructures.ArrayList;
import java.util.concurrent.TimeUnit;

public class VisualRep {
    
    /**
     * The method will show a visual representation of how a pathfinding algorithm
     * goes from the start to the end.
     * @param path The ArrayList that contains the nodes that is the path from start to end.
     * @param map The char[][] representation of the map.
     * @param start The start node.
     * @param end The end node.
     * @throws InterruptedException 
     */
    public void show(ArrayList<Node> path, char[][] map, Node start, Node end) throws InterruptedException{
        for (int i = 0; i < path.size(); i++) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            Node n = path.get(i);
            int y = 0;
            for (char[] c : map) {
                for (int x = 0; x < c.length; x++) {
                    if (x == start.getX() && y == start.getY()){
                        System.out.print("S");
                        map[y][x] = 'S';
                    }
                    else if (x == end.getX() && y == end.getY()){
                        System.out.print("E");
                        map[y][x] = 'E';
                    }
                    else if (x == n.getX() && y == n.getY()) {
                        System.out.print("\u25CF");
                        map[y][x] = '\u25CF';
                    } else {
                        System.out.print(c[x]);
                    }
                }
                System.out.println("");
                y++;
            }
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}
