package Session15;

public class StackWithArray {
    private Object[] stackArray;
    private int top;
    private int capacity;

    public StackWithArray(int size) {
        stackArray = new Object[size];
        capacity = size;
        top = -1;
    }

    public void push(Object item) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack is full");
        }
        stackArray[++top] = item;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top--];
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

}
