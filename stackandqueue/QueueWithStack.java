package stackandqueue;

public class QueueWithStack {

    private Stack in, out;

    QueueWithStack(int size) {
        in = new Stack(size);
        out = new Stack(size);
    }

    void enqueue(int value) throws Exception {
        in.push(value);
    }

    private void fillOut() throws Exception {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }

    /*
     * Dequeue operation - If out stack is empty, all element are popped into out
     * stack and last element is popped from out stack.
     */
    int dequeue() throws Exception {
        if (out.isEmpty()) {
            fillOut();
        }
        return out.pop();
    }

    int size() {
        return in.size() + out.size();
    }

    int front() throws Exception {
        if (out.isEmpty()) {
            fillOut();
        }
        return out.peek();
    }

    boolean isEmpty() {
        return in.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        QueueWithStack qws = new QueueWithStack(5);
        qws.enqueue(0);
        qws.enqueue(1);
        qws.enqueue(2);
        System.out.println("Popped " + qws.dequeue());
        System.out.println("Size " + qws.size());
        System.out.println("Front " + qws.front());
        qws.enqueue(3);
        System.out.println("Popped " + qws.dequeue());
    }

}
