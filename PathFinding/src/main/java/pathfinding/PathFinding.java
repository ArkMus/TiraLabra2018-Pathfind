package pathfinding;
// author Markus Andersson

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;





public class PathFinding {

    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        MapReader mr = new MapReader("src/main/java/pathfinding/Maps/test2.map");
        char[][] map = mr.generateMap();
        Node start = new Node(0, 0, 1);
        Node end = new Node(18, 12, 1);
        
        int anwser = 0;
        String input = "";
        ArrayList<Node> path = new ArrayList<>();
        while(true){
            System.out.println("If you want to use A* press 1\n"
                    + "If you want to use JPS press 2");
            input = sc.nextLine();
            if (input.equals("1")) {
                AStar astar = new AStar(map);
                anwser = astar.find(start, end);
                path = astar.rpath;
                break;
            } else if (input.equals("2")) {
                JPS jps = new JPS(map);
                anwser = jps.find(start, end);
                path = jps.rpath;
                break;
            }else{
                System.out.println("Please type 1 or 2!");
            }
        }
        if (anwser == -1) {
            System.out.println("ERROR, didn't find path...RIP");
        } else {
            VisualRep vr = new VisualRep();
            vr.show(path, map);
            System.out.println("The shortest path is: ");
            System.out.println(path);
            System.out.println("and it's " + anwser + " steps long");
        }

    }

}
