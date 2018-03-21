
package pathfinding;
// author Markus Andersson
 
public class PathFinding {
    
    public static void main(String[] args) {
        int[][] map = {
        {0,0,0,0,0,0,2},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {1,0,0,0,0,0,0}
        };
        AStar ASTAR = new AStar(map);
        Node start = new Node(0, 6, 1);
        Node end = new Node(6, 0, 1);
        int anwser = ASTAR.find(start, end);
        if(anwser == -1){
            System.out.println("ERROR, didn't find path...RIP");
        }else{
            System.out.println("and it's " + anwser + " steps long");
        }
        
    }
    
}
