package stackandqueue;

public class CircularQueue {
    private int[] queue;
    private int size, start = -1, end = -1;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    void enqueue(int value) throws Exception {
        if (isEmpty()) {
            start = end = 0;
        } else if ((end + 1) % size == start) {
            throw new Exception("Queue is full. " + value + " not inserted.");
        } else {
            end = (end + 1) % size;
        }
        queue[end] = value;
    }

    int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty.");
        }
        int temp = queue[start];
        if (end == start + 1) {
            start = end = -1;
        } else {
            start++;
        }
        return temp;
    }

    int front() {
        return queue[start];
    }

    boolean isFull() {
        return end == size - 1 && start == 0 || end == start - 1;
    }

    boolean isEmpty() {
        return start == -1;
    }

    void showQueue() {
        System.out.println("Updated :");
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
        } else
            for (int i = start; i <= (end < start ? size + end : end); i++) {
                System.out.printf("%d  -  %d\n", i % size, queue[i % size]);
            }
    }

    public static void main(String[] args) throws Exception {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.showQueue();
        System.out.println("Poped - " + cq.dequeue());
        cq.showQueue();
        cq.enqueue(40);
        cq.enqueue(50);
        cq.showQueue();
        cq.enqueue(60);
        cq.showQueue();
        // cq.enqueue(70);
        // cq.showQueue();
        System.out.println("Poped - " + cq.dequeue());
        System.out.println("Poped - " + cq.dequeue());
        cq.showQueue();
        // cq.enqueue(60);
        cq.enqueue(70);
        cq.enqueue(80);
        cq.showQueue();
        System.out.println("Poped - " + cq.dequeue());
        cq.showQueue();
    }
}
