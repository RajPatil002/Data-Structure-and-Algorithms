package stackandqueue;

public class StackWithQueue {
    private Queue queue1, queue2;

    StackWithQueue(int size) {
        queue1 = new Queue(size);
        queue2 = new Queue(size);
    }

    private void swapQueues() {
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    void push(int value) throws Exception {
        queue1.enqueue(value);
    }

    int pop() throws Exception {
        while (queue1.size() > 1) {
            queue2.enqueue(queue1.dequeue());
        }
        swapQueues();
        return queue2.dequeue();
    }

    int size() {
        return queue1.size();
    }

    void showStack() {
        queue1.showQueue();
    }

    boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        StackWithQueue swq = new StackWithQueue(5);
        swq.push(0);
        swq.push(1);
        swq.push(2);
        swq.push(3);
        swq.pop();
        swq.pop();
        swq.pop();
        swq.push(4);
        swq.showStack();
    }
}
