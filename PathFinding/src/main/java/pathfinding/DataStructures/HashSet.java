
package pathfinding.DataStructures;
import pathfinding.DataStructures.ArrayList;

/**
 *
 * @author markusan
 */
public class HashSet<E> {
    private Entry<E>[] table;   //Array of Entry.
    private int size = 4;  //Initial size of HashSet
    
    static class Entry<E> {   
        E key;
        Entry<E> next;
    
        public Entry(E key, Entry<E> next) {
            this.key = key;
            this.next = next;
        }
        
    }
    
    public HashSet(){
        this.table = new Entry[this.size];
    }
    
    public void add(E newElement){
        if(newElement == null){
            return; // null element is not allowed
        }
        int hash = hash(newElement);
        
        Entry<E> newEntry = new Entry<>(newElement, null);
        if(table[hash] == null){
            table[hash] = newEntry;
        }else{
            Entry<E> previous = null;
            Entry<E> current = table[hash];
            
            while(current != null){     //The last entry has been reached.
                if(current.key.equals(newElement)){
                    if(previous == null){ //If this is the first entry, it must be inserted.
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    }
                    else{
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }
    /**
     * Returns the true if the set contains the requested element.
     * @param element The element searched for.
     * @return 
     */
    public boolean contains(E element){
        int hash = hash(element);
        if(table[hash] == null){
            return false;
        }
        else{
            Entry<E> temp = table[hash];
            while(temp != null){
                if(temp.key.equals(element)){
                    return true;
                }
                temp = temp.next;
            }
            return false; // If the element is not found, return false.
        }
    }
    
    private int hash(E key) {
        return Math.abs(key.hashCode()) % size;
    }
    
    public String toString(){
        String toReturn = "{";
        int a = 0;
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                Entry<E> entry = table[i];
                while (entry != null) {
                    if(a == 0){
                        toReturn += entry.key;
                        a++;
                    }else{
                        toReturn += ", " + entry.key;
                    }
                    entry = entry.next;
                }
            }
        }
        toReturn += "}";
        return toReturn;
    }
    
    
}