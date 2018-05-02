
package pathfinding.DataStructures;

/**
 *
 * @author markusan
 */
public class PriorityQueue<E> {
    private Node[] list;
    private int current;
    
    /**
     * Initializing the PriorityQueue. A array with the size of 1 is created and
     * the value current is set to 0.
     */
    public PriorityQueue(){
        list = new Node[1];
        current = 0;
    }
    
    
    /**
     * Adding elements to the queue. A element is added to the queue. If the array
     * is full, a copy of it will be created with double the size which will replace
     * the original.
     * @param e The element that will be added to the queue.
     */
    public void add(Node e){
        if(list.length -1 == current){
            Node[] newlist = new Node[(list.length * 2)];
            for(int i = 0; i < list.length; i++){
                newlist[i] = list[i];
            }
            list = newlist;
        }
        if(!isEmpty()){
            int a = current - 1;
            if (e.getCost() > list[a].getCost()) {
                list[current] = e;
            } else {
                while (true) {
                    if(e.getCost() < list[a].getCost()){
                        break;
                    }
                    if (a == 0) {
                        break;
                    }
                    a--;
                }
                Node temp = list[a];
                Node temp2 = null;
                list[a] = e;
                a++;
                while (a <= current) {
                    temp2 = list[a];
                    list[a] = temp;
                    a++;
                    temp = temp2;
                }
            }
        }else{
            list[current] = e;
        }
        current++;  
    }
    /**
     * Get the item with the highest priority and delete it from the queue. 
     * @return 
     */
    public Node poll(){
        Node returNode = list[0];
        Node[] newList = new Node[list.length];
        int x = 0;
        for(int i = 1; i < list.length; i++){
            newList[x] = list[i];
            x++;
        }
        if(current != 0){
            current--;
        }
        list = newList;
        return returNode;
    }
    
    public boolean contains(Node e){
        for(int i = 0; i < current; i++){
            Node n = list[i];
            if(n.equal(e)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty(){
        for(int i = 0; i < current; i++){
            Node n = list[i];
            if(n != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String a = "[";
        
        for(int i = 0; i < list.length; i++){
            if(list[i] == null){
                break;
            }
            if(i == 0){
                a += list[i];
            }
            else{
                a += ", " + list[i];
            }
        }
        a+= "]";
        return a;
    }
}
