package laboration6;

import laboration4.ArrayListStack;

public class TestArrayListStack {
    public static void main(String[] args) {
        ArrayListStack<Integer> stack = new ArrayListStack<Integer>();
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
        }
        System.out.println("size=" + stack.size());
        System.out.println("Senast placerad i stacken:");
        System.out.println(stack.peek());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
