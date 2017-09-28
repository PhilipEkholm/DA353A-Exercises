package laboration6;

public class TestCircularArray {
	public static void main(String[] args) {
		ArrayQueue<Integer> circularArray = new ArrayQueue<Integer>(10);
		
		for(int i = 0; i < 50; i+=5){
			circularArray.enqueue(i);
			System.out.println("Size: " + circularArray.size() + ", Elem: " + circularArray.peek());
		}
		
		circularArray.dequeue();
		circularArray.dequeue();
		System.out.println(circularArray.peek());
		circularArray.enqueue(170);
		circularArray.enqueue(250);
		circularArray.dequeue();
		circularArray.dequeue();
		circularArray.dequeue();
		circularArray.dequeue();
		circularArray.dequeue();
		circularArray.dequeue();
		circularArray.dequeue();
		circularArray.dequeue();
		
		System.out.println(circularArray.peek());
		circularArray.dequeue();
		System.out.println(circularArray.peek());
		System.out.println(1 / 10);
		System.out.println(2 / 10);
		System.out.println(3 / 10);
		System.out.println(4 / 10);
	}
}
