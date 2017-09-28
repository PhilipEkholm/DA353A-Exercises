package laboration9;
import collections.LinkedList;

public class StringValues {
    private LinkedList<String>[] lists;
    
    public StringValues( int capacity ) {
        lists = new LinkedList[capacity];
        for( int i=0; i<lists.length; i++ )
            lists[i] = new LinkedList<String>();
    }
    
    public void add( int index, String value ) {
    	lists[index].add(value);
    }
    
    public boolean remove(int index, String value){
    	int indexInList = lists[index].indexOf(value);
    	String str;
    	
    	if(indexInList == -1){
    		return false;
    	}
    	else{
    		str = lists[index].remove(indexInList);
    	}
    	
    	if(str != null){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
        
    public void printValues() {
        for( int listIndex = 0; listIndex<lists.length; listIndex++ ) {
            System.out.print( String.format("%4d: ", listIndex) );
            for( int elemIndex = 0; elemIndex < lists[listIndex].size(); elemIndex++) {
                System.out.print( lists[listIndex].get(elemIndex) );
                if( elemIndex < lists[listIndex].size()-1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }
    
    public int size(){
    	int totalSize = 0;
    	
    	for(int i = 0; i < lists.length; i++){
    		totalSize += lists[i].size();
    	}
    	
    	return totalSize;
    }

    public static void main(String[] args) {
        StringValues values = new StringValues(10);
        values.add(7,"Bra");
        values.add(9,"Gott");
        values.add(5,"Fint");
        values.add(7,"Utsökt");
        values.add(7,"Excellent");
        values.add(4,"Utmärkt");
        values.add(5,"Kanon");
        values.add(3,"Magnifikt");
        values.add(7,"Superbt");
        values.add(5,"Helgjutet");
        values.add(1,"5-stjärningt");
        System.out.println("Tar bor 'Kanon' ur lista 3: " + values.remove(3, "Kanon"));
        System.out.println("Tar bor 'Kanon' ur lista 5: " + values.remove(5, "Kanon"));
        System.out.println("Tar bor 'Kanon' ur lista 5: " + values.remove(5, "Kanon"));
        System.out.println("Antal värden: " + values.size() );
        System.out.println("Tar bor 'Excellent': " + values.remove(7, "Excellent"));
        System.out.println("Tar bor 'Excellent': " + values.remove(7, "Excellent"));
        values.printValues();
    }
}
