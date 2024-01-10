package stackandqueue;

public class PriorityQueue {
    private int size;
    private int[] queue;
    private int end = 0;

    PriorityQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    private void heapify(int i) {
        int l = i * 2 + 1, r = l + 1;
        if (queue[l] > queue[r] && l < end) {
            if (queue[l] > queue[i]) {
                int temp = queue[l];
                queue[l] = queue[i];
                queue[i] = temp;
                heapify(l);
            }
        } else if (r < end) {
            if (queue[r] > queue[i]) {
                int temp = queue[r];
                queue[r] = queue[i];
                queue[i] = temp;
                heapify(r);
            }
        }
    }

    private void reheap() {
        for (int i = end - 2; i >= 0; i--) {
            heapify(i);
        }
    }

    void enqueue(int value) throws Exception {
        if (end < size) {
            queue[end++] = value;
            reheap();
        } else {
            throw new Exception("Queue is full. " + value + " not inserted.");
        }
    }

    int dequeue() {
        int temp = queue[0];
        queue[0] = queue[--end];
        reheap();
        return temp;
    }

    void showQueue() {
        System.out.println("Updates :");
        for (int i = 0; i < end; i++) {
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue pq = new PriorityQueue(10);
        pq.enqueue(0);
        pq.enqueue(1);
        pq.showQueue();
        pq.enqueue(2);
        pq.showQueue();
        pq.enqueue(3);
        pq.showQueue();
        pq.enqueue(4);
        pq.showQueue();
        // pq.enqueue(5);
        // pq.showQueue();
        System.out.println("Popped " + pq.dequeue());
        pq.showQueue();
        System.out.println("Popped " + pq.dequeue());
        pq.showQueue();
        System.out.println("Popped " + pq.dequeue());
        pq.showQueue();
    }
}
