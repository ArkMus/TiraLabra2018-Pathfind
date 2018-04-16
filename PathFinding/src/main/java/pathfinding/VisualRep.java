
package pathfinding;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class VisualRep {
    
    void show(ArrayList<Node> path, char[][] map) throws InterruptedException{
        for (Node n : path) {
            int y = 0;
            for (char[] c : map) {
                for (int x = 0; x < c.length; x++) {
                    if (x == n.getX() && y == n.getY()) {
                        System.out.print("#");
                        map[y][x] = '#';
                    } else {
                        System.out.print(c[x]);
                    }
                }
                System.out.println("");
                y++;
            }
            System.out.println("\n\n");
            TimeUnit.MILLISECONDS.sleep(50);
        }
    }
}
