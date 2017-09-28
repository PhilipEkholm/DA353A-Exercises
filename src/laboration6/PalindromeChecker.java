package laboration6;

import javax.swing.JOptionPane;

public class PalindromeChecker {
	LinkedStack<Character> stack = new LinkedStack<Character>();
	LinkedQueue<Character> queue = new LinkedQueue<Character>();
	
	public static void main(String[] args) {
		PalindromeChecker pc = new PalindromeChecker();
		
		String s = JOptionPane.showInputDialog("Mata in ett palindrom och kontrollera");
		boolean checker = pc.isItAPalindrome(s);
		
		if(checker){
			JOptionPane.showMessageDialog(null, s + " är ett palindrom!");
		}
		else{
			JOptionPane.showMessageDialog(null, s + " är inte ett palindrom.");
		}
	}
	
	private boolean isItAPalindrome(String s){
		s = s.toLowerCase();
		
		int l = s.length();
		
		for(int i = 0; i < l; i++){
			if(i < (l/2)){
				queue.enqueue(s.charAt(i));
			}
			//Add an extra char if the string has an odd number of characters
			if(i == (l/2) && l % 2 == 1){
				queue.enqueue(s.charAt(i));
			}
			if(i >= l/2){
				stack.push(s.charAt(i));
			}
		}
		
		String 	queueString = addCharsFromQueue(""),
				stackString = addCharsFromStack("");
		
		return queueString.equals(stackString);
	}
	
	private String addCharsFromQueue(String s){
		if(queue.isEmpty()){
			return s;
		}
		else{
			return addCharsFromQueue(s + queue.dequeue());
		}
	}
	
	private String addCharsFromStack(String s){
		if(stack.isEmpty()){
			return s;
		}
		else{
			return addCharsFromStack(s + stack.pop());
		}
	}
}









