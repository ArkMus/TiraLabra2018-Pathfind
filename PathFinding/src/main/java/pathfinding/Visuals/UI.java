
package pathfinding.Visuals;

import java.util.Scanner;
import pathfinding.DataStructures.ArrayList;
import pathfinding.DataStructures.Node;
import pathfinding.PathFinders.AStar;
import pathfinding.PathFinders.JPS;

/**
 *
 * @author markusan
 */
public class UI {
    
    public UI(){
        
    }
    
    public void run() throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        Node start = null;
        Node end = null;
        MapReader mr = null;
        char[][] map = null;
        int anwser = 0;
        String input = "";
        ArrayList<Node> path = new ArrayList<>();
        long aikaAlussa = 0;
        long aikaLopussa = 0;

        while (true) {
            System.out.println("Which map would you like to use?\n"
                    + "For 'test.map' press 1\n"
                    + "For 'test2.map' press 2\n"
                    + "For 'test3.map' press 3");
            input = sc.nextLine();
            if (input.equals("1")) {
                mr = new MapReader("src/main/java/pathfinding/Maps/test.map");
                start = new Node(0, 6, 1);
                end = new Node(6, 0, 1);
            } else if (input.equals("2")) {
                mr = new MapReader("src/main/java/pathfinding/Maps/test2.map");
                start = new Node(0, 0, 1);
                end = new Node(18, 12, 1);
            } else if (input.equals("3")) {
                mr = new MapReader("src/main/java/pathfinding/Maps/test3.map");
                start = new Node(0, 0, 1);
                end = new Node(75, 25, 1);
            } else {
                System.out.println("Please type 1, 2 or 3!");
                continue;
            }
            map = mr.generateMap();
            System.out.println("If you want to use A* press 1\n"
                    + "If you want to use JPS press 2");
            input = sc.nextLine();
            if (input.equals("1")) {
                AStar astar = new AStar(map);
                anwser = astar.find(start, end);
                path = astar.rpath;
                aikaAlussa = astar.aikaAlussa;
                aikaLopussa = astar.aikaLopussa;
                break;
            } else if (input.equals("2")) {
                JPS jps = new JPS(map);
                anwser = jps.find(start, end);
                path = jps.rpath;
                aikaAlussa = jps.aikaAlussa;
                aikaLopussa = jps.aikaLopussa;
                break;
            } else {
                System.out.println("Please type 1 or 2!");
            }
        }
        if (anwser == -1) {
            System.out.println("ERROR, didn't find path...RIP");
        } else {
            VisualRep vr = new VisualRep();
            vr.show(path, map, start, end);
            System.out.println("The shortest path is: ");
            System.out.println(path);
            System.out.println("and it's " + anwser + " steps long");
        }
        System.out.println("Operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
    }
}
