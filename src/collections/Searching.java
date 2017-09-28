package collections;

/**
 *	The Searching class contains two methods for searching an ArrayList of any homogeneous type. If the list is sorted then
 *	binarySearch may be used, otherwise linearSearch can be used.
 *
 *	@author Philip Ekholm 
 */

public class Searching {
	
	/**
	 *	Perform a binary search in an ArrayList, will only work if the list has been sorted, will return -1 if element not found.
	 *
	 *	@param list the list to be searched through
	 *	@param element the element in question
	 *	@return the index of the element at found position. If position not found -1 will be returned.
	 */
	
	public static<E> int binarySearch(ArrayList<E> list, Object element){
		//Assumes that object passed is implementing Comparable, otherwise the program will crash.
		Comparable<E> comp = (Comparable<E>)element;
		int res = -1, min = 0, max = list.size() - 1, pos;
		
		while(min <= max && res == -1){
			pos = (min + max) / 2;
			
			if(comp.compareTo(list.get(pos)) == 0){
				res = pos;
			}
			else if(comp.compareTo(list.get(pos)) < 0){
				max = pos - 1;
			}
			else if(comp.compareTo(list.get(pos)) > 0){
				min = pos + 1;
			}
		}
		
		return res;
	}
	
	/**
	 *	Perform a "regular" linear search for an element. This is equivalent of the indexOf method for some objects.
	 *
	 * 	@param list the list to be searched through
	 *	@param element the element in question
	 *	@return the index of the element at found position. If position not found -1 will be returned.
	 */
	
	public static<E> int linearSearch(ArrayList<E> list, E element){
		for(int i = 0; i < list.size(); i++){
			if(element.equals(list.get(i))){
				return i;
			}
		}
		
		return -1;
	}
}
