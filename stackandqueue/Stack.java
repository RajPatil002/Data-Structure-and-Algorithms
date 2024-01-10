package stackandqueue;

/**
 * stack
 */
public class Stack extends Exception {
    private int size;
    private int peek = 0;
    private int[] stack;

    Stack(int size) {
        this.size = size;
        stack = new int[size];
    }

    int size() {
        return peek;
    }

    void push(int value) throws Exception {
        if (peek < size) {
            stack[peek] = value;
            peek++;
        } else {
            throw new Exception("Cannot insert into full Stack");
        }
    }

    int pop() throws Exception {
        if (peek > 0) {
            return stack[--peek];
        } else {
            throw new Exception("Cannot pop from empty Stack");
        }
    }

    int peek() throws Exception {
        if (!isEmpty()) {
            return stack[peek - 1];
        }
        throw new Exception("Stack is empty.");
    }

    void showStack() {
        for (int i = 0; i < peek; i++) {
            System.out.println(stack[i]);
        }
    }

    boolean isEmpty() {
        return peek == 0;
    }

    public static void main(String[] args) throws Exception {
        Stack s = new Stack(5);
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
        s.showStack();
        s.push(0);
        s.push(1);
        s.pop();
        s.push(5);
        System.out.println(s.size());
        s.showStack();
    }
}