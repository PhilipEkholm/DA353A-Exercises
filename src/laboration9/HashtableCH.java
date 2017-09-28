package laboration9;
import f9.Map;
import java.util.Iterator;
import collections.ArrayList;

/**
 * Hashtabellen använder sluten hashing
 * @author Rolf Axelsson
 **/

public class HashtableCH<K,V> implements Map<K,V> {
    private Bucket<K,V>[] table;
    private int size;
    private int threshold;
    private double loadfactor = 0.7;
    
    public HashtableCH( ) {
    	this(11);
    }
    
    public HashtableCH( int size ) { 
        table = (Bucket<K,V>[])new Bucket[ size ];
        threshold = (int)(loadfactor*table.length);
        for( int i = 0; i < table.length; i++ ) {
            table[ i ] = new Bucket<K,V>();
        }
    }
    
    private void grow() {
    	Bucket<K,V>[] oldTable = table;
        table = (Bucket<K,V>[])new Bucket[ table.length*2 ];
    	threshold = (int)(loadfactor*table.length);
    	
        for( int i = 0; i < table.length; i++ ) {
        	if(i < oldTable.length){
        		table[i] = oldTable[i];
        	}
        	else{
        		table[i] = new Bucket<K,V>();
        	}
        }
    }
    
    private int hashIndex( K key ) {
        int hashCode = key.hashCode();
        hashCode = hashCode % table.length;
        
        return Math.abs(hashCode);
    }
    
    public V put( K key, V value ) {
    	V res = null;
    	if( size >= threshold ) {
    		grow();
    	}
    	int hashIndex = hashIndex( key ), removed = -1;
    	while( table[ hashIndex ].state != Bucket.EMPTY && !key.equals(table[ hashIndex ].key) ) {
    		if( removed == -1 && table[ hashIndex ].state == Bucket.REMOVED )
    			removed = hashIndex;
    		hashIndex++;
    		if(hashIndex==table.length)
    			hashIndex=0;
    	}
    	if( table[ hashIndex ].state == Bucket.OCCUPIED ) {
    		res = table[ hashIndex ].value;
    		table[ hashIndex ].value = value;
    	} else {
    		if( removed != -1 ) 
    			hashIndex = removed;
            table[ hashIndex ].key = key;
            table[ hashIndex ].value = value;
            table[ hashIndex ].state = Bucket.OCCUPIED;
            size++;
    	}
    	return res;
    }

	public Iterator<K> keys() {
		ArrayList<K> keys = new ArrayList<K>();
		for(int i=0; i<table.length; i++)
		    if( table[ i ].state == Bucket.OCCUPIED )
			    keys.add(table[ i ].key);
		return keys.iterator();
	}
	
    public void list() {
        System.out.println( "Tabellen innehåller " + size() + " element:" );
        for(int i=0; i<table.length; i++)
            System.out.println(i+": key=" + table[ i ].key +" value=" + table[ i ].value + " state=" + table[ i ].state );
    }    
    
    public V get(K key) {
        int position = this.hashIndex(key);
        int i = 0;
        
        while(i < table.length && table[position].state != Bucket.EMPTY && !key.equals(table[position].key)){
        	position++;
        	i++;
        }
        
        return key.equals(table[position].key) ? table[position].value : null;
    }
    
    public V remove( K key ) {
        int position = this.hashIndex(key);
        int i = 0;
 
        while(i < table.length && table[position].state != Bucket.EMPTY && !key.equals(table[position].key)){
        	position++;
        	i++;
        }
        
        if(key.equals(table[position].key)){
        	V value = table[position].value;
        	
        	table[position].key = null;
        	table[position].value = null;
        	
        	table[position].state = Bucket.REMOVED;
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
		return (this.size <= 0);
	}

	public boolean containsKey(K key) {
		return (this.get(key) != null);
	}

	public void clear() {
		for(int i = 0; i < table.length; i++){
			table[i].key = null;
			table[i].value = null;
			
			table[i].state = Bucket.EMPTY;
		}
		
		size = 0;
	}

	public Iterator<V> values() {
		return new Iter();
	}
	
	private class Iter implements Iterator<V>{
		private ArrayList<V> list = new ArrayList<V>(size());

		@Override
		public boolean hasNext() {
			return (list.size() > 0);
		}
		
		public Iter(){
			for(int i = 0; i < table.length; i++){
				if(table[i].state == Bucket.OCCUPIED){
					list.add(table[i].value);
				}
			}
		}

		@Override
		public V next() {
			return list.removeLast();
		}
		
	}
	
    public static void main(String[] args) {
        HashtableCH<String,String> table = new HashtableCH<String,String>(1);
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
        System.out.println("-----KEYS-------------------------");
	    Iterator<String> keys = table.keys();
	    while(keys.hasNext())
		    System.out.println(keys.next());
	    
	    System.out.println(table.get("gul"));
    }
}

