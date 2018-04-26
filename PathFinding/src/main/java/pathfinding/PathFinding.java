package pathfinding;
// author Markus Andersson

import java.util.Scanner;
import pathfinding.DataStructures.ArrayList;
import pathfinding.DataStructures.HashMap;


public class PathFinding {

    public static void main(String[] args) throws InterruptedException{
        
        Scanner sc = new Scanner(System.in);
        Node start = null;
        Node end = null;
        MapReader mr = null;
        char[][] map = null;
        int anwser = 0;
        String input = "";
        ArrayList<Node> path = new ArrayList<>();
        while(true){
            System.out.println("Which map would you like to use?\n"
                    + "For 'test.map' press 1\n"
                    + "For 'test2.map' press 2");
            input = sc.nextLine();
            if(input.equals("1")){
                mr = new MapReader("src/main/java/pathfinding/Maps/test.map");
                start = new Node(0, 0, 1);
                end = new Node(6, 6, 1);
            }
            else if(input.equals("2")){
                mr = new MapReader("src/main/java/pathfinding/Maps/test2.map");
                start = new Node(0, 0, 1);
                end = new Node(18, 12, 1);
            }
            else{
                System.out.println("Please type 1 or 2!");
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
