
package pathfinding.Visuals;

import pathfinding.DataStructures.Node;
import pathfinding.DataStructures.ArrayList;
import java.util.concurrent.TimeUnit;

public class VisualRep {
    
    public void show(ArrayList<Node> path, char[][] map, Node start, Node end) throws InterruptedException{
        for (int i = 0; i < path.size(); i++) {
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
            System.out.println("\n\n");
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}
