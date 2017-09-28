package laboration4;
import java.util.Arrays;

import arrays.ArraySupporter;

public class DynamicString implements Comparable<DynamicString>{
	private char[] chars;
	private int length;
	
	public DynamicString() {
		chars = new char[10];  
	}
	
	public DynamicString( DynamicString str ) {
		chars = Arrays.copyOf(str.chars, str.length);
		length = str.length;
	}
	
	public DynamicString(String str) {
		chars = str.toCharArray();
		length = chars.length;
	}
	
	public void add(char chr) {
		add(length,chr);
	}
	
	public void add(int index, char chr) {
		checkIndex(index,length);
		if(length==chars.length) {
			chars = Arrays.copyOf(chars,chars.length*2);
		}
    	for(int i=length; i>index;i--) {
    		chars[i] = chars[i-1];
    	}
    	chars[index] = chr;
    	length++;
	}
	
	public char charAt(int index){
		if(index < 0 || index > length){
			throw new IndexOutOfBoundsException();
		}
		
		return this.chars[index];
	}
	
	public void concat(DynamicString str) {
		String copy = str.toString();
		for(int i=0; i < copy.length(); i++) {
			this.add(copy.charAt(i));
			
		}
	}
	
	public boolean equals(Object obj){
		if(obj instanceof DynamicString){
			String s1 = ((DynamicString) obj).chars.toString(),
					s2 = this.chars.toString();
			
			if(s1.equals(s2)){
				return true;
			}
		}
		
		return false;
	}
	
	public int indexOf(char chr){
		for(int i = 0; i < length; i++){
			if(chars[i] == chr){
				return i;
			}
		}
		
		return -1;
	}
	
	public int indexOf(DynamicString str){
		String 	s1 = str.toString();
		String s2 = this.toString();
		
		return s2.indexOf(s1);
	}
	
	public int length(){
		return this.length;
	}
	
	public void remove(int index) {
		checkIndex(index,length-1);
        for(int i=index+1; i<length; i++) {
			chars[i-1] = chars[i];
		}
        length--;
	}
	
	public void removeAll(){
		for(int i = 0; i < this.length; i++){
			this.remove(i);
		}
		
		this.length = 0;
	}
	
	public String toString() {
		return new String(chars, 0, length);
	}	
	
	// tas upp på föreläsning 9
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = 31 * hash + chars[i];
        }
        return hash;
    }
    
    // kontroll av index
	private void checkIndex(int index, int max) {
		if(index<0 || index>max) {
			throw new IndexOutOfBoundsException("index: "+index+", range: 0-"+max);
		}
	}
	
	public DynamicString substring(int start, int end){
		if(start < 0 || end > length || start > end){
			throw new IndexOutOfBoundsException();
		}
		else if(start == end){
			return new DynamicString();
		}
		
		String copy = String.valueOf(chars);
		copy = copy.substring(start, end);
		
		return new DynamicString(copy);
	}
	
	public DynamicString substring(int start){
		return this.substring(start, length);
	}
		
	public static void main(String[] args) {
//		DynamicString ds1 = new DynamicString();            // ds1 -> DynamicString med längden 0
//		DynamicString ds2 = new DynamicString("Hej Lisa!"); // ds2 -> DynamicString med 'H','e','j',' ','L','i','s','a','!'
//		DynamicString ds3 = new DynamicString(ds2);         // ds3 -> DynamicString med 'H','e','j',' ','L','i','s','a','!'
//		System.out.println("ds1: " + ds1);
//		System.out.println("ds2: " + ds2);
//		System.out.println("ds3: " + ds3);
//		ds1.add('J');                                       // ds1 -> 'J'
//		ds1.add('a');                                       // ds1 -> 'J','a'
//		ds1.add('a');                                       // ds1 -> 'J','a','a'
//		ds1.add(2,'v');                                     // ds1 -> 'J','a','v','a'
//		ds2.remove(4);                                      // ds2 -> 'H','e','j',' ','i','s','a','!'
//		ds2.remove(4);                                      // ds2 -> 'H','e','j',' ','s','a','!'
//		System.out.println("ds1: " + ds1);
//		System.out.println("ds2: " + ds2);
//		System.out.println("ds3: " + ds3);
//		
//		System.out.println(ds3.length);
//		
//		System.out.println(ds3.indexOf('8'));
//		
//		System.out.println(ds2);
//		ds2.concat(ds2);
//		System.out.println(ds2);
//		
//		DynamicString[] strings = {
//				 new DynamicString("Orm"),new DynamicString("Kråka"),
//				 new DynamicString("Ärm"),new DynamicString("Kraka"),
//				 new DynamicString("ångan"),new DynamicString("Kråkan"),
//				 new DynamicString("ånga"),new DynamicString("Ånga"),
//				 new DynamicString("krycka"),new DynamicString("Kräka"),
//				 new DynamicString("ärm"),new DynamicString("Kröka") };
//				for(int i=0; i<strings.length; i++) {
//				 System.out.print(strings[i] + " ");
//				}
//				System.out.println();
//				Arrays.sort(strings);
//				for(int i=0; i<strings.length; i++) {
//				 System.out.print(strings[i] + " ");
//				}
				
		DynamicString ds1 = new DynamicString( "Studentudent" );
		DynamicString ds2 = new DynamicString( "ude" );
		DynamicString ds3 = new DynamicString( "Anders" );
		System.out.println( ds1.indexOf( ds2 ) );
		System.out.println( ds1.indexOf( ds3 ) );
	}

	@Override
	public int compareTo(DynamicString d1) {
		char 	c1 = this.chars[0],
				c2 = d1.chars[0];
		
		if(c1 > c2){
			return 1;
		}
		else if(c1 < c2){
			return -1;
		}
		
		return 0;
	}
}













