package stackandqueue;

public class Queue {
    private int size;
    private int[] queue;
    private int end = 0;

    Queue(int size) {
        this.size = size;
        queue = new int[size];
    }

    int dequeue() throws Exception {
        if (end > 0) {
            int temp = queue[0];
            for (int i = 0; i < end - 1; i++) {
                queue[i] = queue[i + 1];
            }
            end--;
            return temp;
        } else {
            throw new Exception("Queue is empty.");
        }
    }

    void enqueue(int value) throws Exception {
        if (end < size) {
            queue[end] = value;
            end++;
        } else {
            throw new Exception("Queue is full.");
        }
    }

    int front() throws Exception {
        if (!isEmpty()) {
            return queue[0];
        }
        throw new Exception("Queue is empty.");
    }

    int size() {
        return end;
    }

    boolean isEmpty() {
        return end == 0;
    }

    void showQueue() {
        for (int i = 0; i < end; i++) {
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Queue q = new Queue(5);
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.dequeue();
        System.out.println(q.front());
        q.enqueue(3);
        q.enqueue(4);
        q.showQueue();
        System.out.println("END");

    }

}
