package pathfinding;
// author Markus Andersson



public class PathFinding {

    public static void main(String[] args) {
        MapReader mr = new MapReader("src/main/java/pathfinding/Maps/test2.map");
        char[][] map = mr.generateMap();
        AStar astar = new AStar(map);
        JPS jps = new JPS(map);
        Node start = new Node(0, 0, 1);
        Node end = new Node(18, 12, 1);
//        int anwser = astar.find(start, end);
        int anwser = jps.find(start, end);
        if (anwser == -1) {
            System.out.println("ERROR, didn't find path...RIP");
        } else {
            System.out.println("and it's " + anwser + " steps long");
        }
        


    }

}
