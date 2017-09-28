package laboration9;
import java.util.Iterator;
import f9.Map;
import collections.ArrayList;
import collections.LinkedList;

/**
 * Hashtabellen använder öppen hashing
 * @author Rolf Axelsson
 */
public class HashtableOH<K,V> implements Map<K,V> { 
    private LinkedList<Entry<K,V>>[] table;
    private int size;
    
    /** Creates a new instance of HashtableOH */
    public HashtableOH( int size ) {
        table = (LinkedList<Entry<K,V>>[])new LinkedList[ size ];
        for( int i = 0; i < size; i++ ) {
            table[ i ] = new LinkedList<Entry<K,V>>();
        }
    }
    
    private int hashIndex( K key ) {
        int hashCode = key.hashCode();
        hashCode = hashCode % table.length;
        
        return Math.abs(hashCode);
    }
    
    public V put( K key, V value ) {
    	V res = null;
        int hashIndex = hashIndex( key );
        Entry<K,V> entry = new Entry<K,V>( key, value );
        int index = table[ hashIndex ].indexOf( entry );
        if( index == -1 ) {
            table[ hashIndex ].addFirst( entry );
            size++;
        }
        else {
        	res = table[hashIndex].set( index, entry ).value;
        }
        return res;
    }
    
    public void list() {
        Entry<K,V> entry;
        for(int i=0; i<table.length; i++) {
            System.out.print( i + ":");
            for( int j = 0; j < table[ i ].size(); j++ ) {
                entry = table[ i ].get( j );
                System.out.print(" <" + entry.key +"," + entry.value + ">" );
            }
            System.out.println();
        }
    }

	public V get(K key) {
		int position = this.hashIndex(key);
		Entry<K, V> newEntry = new Entry<K, V>(key, null);
		int listIndex = table[position].indexOf(newEntry);
		
		if(listIndex == -1){
			return null;
		}
		
		Entry<K, V> ref = table[position].get(listIndex);
		
		if(ref.equals(newEntry)){
			return ref.value;
		}
		else{
			return null;
		}
	}

	public V remove(K key) {
		int position = this.hashIndex(key);
		Entry<K, V> newEntry = new Entry<K, V>(key, null);
		int listIndex = table[position].indexOf(newEntry);
		
		if(listIndex == -1){
			return null;
		}
		
		Entry<K, V> ref = table[position].get(listIndex);
		
		if(ref.equals(newEntry)){
			V value = ref.value;
			ref = null;
			table[position].remove(listIndex);
			size--;
			return value;
		}
		else{
			return null;
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return (size <= 0);
	}

	public boolean containsKey(K key) {
		return (this.get(key) != null);
	}

	public void clear() {
		for(int i = 0; i < table.length; i++){
			table[i].clear();
		}
	}

	public Iterator<K> keys() {
		ArrayList<K> list = new ArrayList<K>();
		
		for(int i = 0; i < table.length; i++){
			if(table[i] != null){
				while(table[i].size() > 0){
					list.add(table[i].removeLast().key);
				}
			}
		}
		
		return list.iterator();
	}

	public Iterator<V> values() {
		ArrayList<V> list = new ArrayList<V>();
		
		for(int i = 0; i < table.length; i++){
			if(table[i] != null){
				while(table[i].size() > 0){
					list.add(table[i].removeLast().value);
				}
			}
		}
		
		return list.iterator();
	}
    
    public static void main(String[] args) {
        HashtableOH<String,String> table = new HashtableOH<String,String>(4);
        table.put("hej", "hello");      
        table.put("röd", "red");        
        table.put("vit", "white");      
        table.put("säng", "bed");       
        table.put("svart", "black");    
        table.put("gul", "yellow");     
        table.put("dator", "computer"); 
        table.put("snö", "snow");       
        table.put("blå", "blue");       
        table.put("grön", "green");     
        table.put("hus", "house");      
        table.list();
    }
}
