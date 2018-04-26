
package pathfinding.DataStructures;
import pathfinding.DataStructures.ArrayList;
/**
 *
 * @author markusan
 */
public class HashMap<K, V> {
    private Entry<K, V>[] table;   //Array of Entry.
    private int size = 4;  //Initial size of HashMap
    public ArrayList<K> set;
    
    static class Entry<K, V> {   
        K key;
        V value;
        Entry<K, V> next;
    
        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
    }
    
    public HashMap(){
        this.table = new Entry[this.size];
        this.set = new ArrayList<>();
    }
    /**
     * Puts a value in the map with the key that is given. If the key that is given
     * is already in use, the value in that place will be replaced by the new value.
     * @param newKey The key that will be used.
     * @param Value The value that will be put into the map.
     */
    public void put(K newKey, V Value){
        if(newKey == null){
            return; // null key is not allowed
        }
        this.set.add(newKey);
        int hash = hash(newKey);
        
        Entry<K,V> newEntry = new Entry<K,V>(newKey, Value, null);
        if(table[hash] == null){
            table[hash] = newEntry;
        }else{
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];
            
            while(current != null){     //The last entry has been reached.
                if(current.key.equals(newKey)){
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
     * Returns the value that corresponds to the key.
     * @param key The key which is used to find the value.
     * @return 
     */
    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }
        else{
            Entry<K,V> temp = table[hash];
            while(temp != null){
                if(temp.key.equals(key)){
                    return temp.value;
                }
                temp = temp.next;
            }
            return null; // If the key is not found, return null.
        }
    }
    
    private int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }
    
    public String toString(){
        String toReturn = "{";
        int a = 0;
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    if(a == 0){
                        toReturn += entry.key + "=" + entry.value;
                        a++;
                    }else{
                        toReturn += ", " + entry.key + "=" + entry.value;
                    }
                    entry = entry.next;
                }
            }
        }
        toReturn += "}";
        return toReturn;
    }
    
    
}
