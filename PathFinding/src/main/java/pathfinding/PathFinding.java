
package pathfinding;
// author Markus Andersson
 
public class PathFinding {
    
    public static void main(String[] args) {
        Map_reader mr = new Map_reader("/home/markusan/uniprojects/TiraLab/TiraLabra2018-Pathfind/PathFinding/src/main/java/pathfinding/Maps/test.map");
        char[][] map = mr.generateMap();
        AStar ASTAR = new AStar(map);
        Node start = new Node(6, 0, 1);
        Node end = new Node(0, 6, 1);
        int anwser = ASTAR.find(start, end);
        if(anwser == -1){
            System.out.println("ERROR, didn't find path...RIP");
        }else{
            System.out.println("and it's " + anwser + " steps long");
        }
        
//        Map_reader mr = new Map_reader("/home/markusan/uniprojects/TiraLab/TiraLabra2018-Pathfind/PathFinding/src/main/java/pathfinding/Maps/64room_000.map");
//        char[][] map = mr.generateMap();
//        
//        for(char[] c : map){
//            for(int i = 0; i < c.length; i++){
//                System.out.print(c[i]);
//            }
//            System.out.println("");
//        }
        
    }
    
}
