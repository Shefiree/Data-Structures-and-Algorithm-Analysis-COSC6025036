package Session15;

public class MainStack {
    public static void main(String[] args) {

        System.out.println("=== Stack dengan Linked List ===");
        StackWithLinkedList<Integer> stack = new StackWithLinkedList<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.peek());
        stack.display();

        System.out.println("\n=== Stack dengan Array ===");
        StackWithArray stackArray = new StackWithArray(5);

        stackArray.push(100);
        stackArray.push(200);
        stackArray.push(300);

        System.out.println("Top element: " + stackArray.peek());

        System.out.println("Popped element: " + stackArray.pop());
        System.out.println("Top element after pop: " + stackArray.peek());
        stackArray.display();

    }
}