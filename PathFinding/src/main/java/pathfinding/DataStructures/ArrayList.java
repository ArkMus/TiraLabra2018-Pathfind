
package pathfinding.DataStructures;

/**
 *
 * @author markusan
 */
public class ArrayList<E> {
    private Object[] list;
    private int current;
    
    /**
     * Initializing the ArrayList. A array with the size of 1 is created and
     * the current is set to 0.
     */
    public ArrayList(){
        list = new Object[1];
        current = 0;
    }
    /**
     * Adding elements to the list. A element is added to the list. If the array
     * is full, a copy of it will be created with double the size which will replace
     * the original.
     * @param e The element that will be added to the list.
     */
    public void add(E e){
        if(list.length -1 == current){
            Object[] newlist = new Object[(list.length * 2)];
            for(int i = 0; i < list.length; i++){
                newlist[i] = list[i];
            }
            list = newlist;
        }
        list[current] = e;
        current++;  
    }
    /**
     * Getting a element from the list. The element that corresponds to the index
     * is returned. If the index is out of bounds, a IndexOutOfBoundsException is
     * thrown.
     * @param i the index.
     * @return 
     */
    public E get(int i){
        if(i > list.length-1 || i < 0){
            throw new IndexOutOfBoundsException("Index " + i + "is out of bounds!");
        }
        
        return (E)list[i];
    }
    /**
     * The list gets reversed. A copy is made of the array that has the elements
     * reversed, then the reversed list replaces the original.
     */
    public void reverse(){
        Object[] revlist = new Object[list.length];
        
        int a = current-1;
        for(int i = 0; i < current; i++){
            revlist[i] = list[a];
            a--;
        }
        list = revlist;
    }
    /*
    The size of the current list is returned.
    */
    public int size(){
        return current;
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
