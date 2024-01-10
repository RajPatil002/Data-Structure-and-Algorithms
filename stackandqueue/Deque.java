package stackandqueue;

public class Deque {

    private int[] queue;
    private int size;
    private int back = 0;

    Deque(int size) {
        this.size = size;
        queue = new int[size];
    }

    void enqueue(int value) throws Exception {
        if (back < size) {
            queue[back++] = value;
        } else {
            throw new Exception("Queue is full.");
        }
    }

    int dequeue() throws Exception {
        if (back > 0) {
            int temp = queue[0];
            for (int i = 0; i < back - 1; i++) {
                queue[i] = queue[i + 1];
            }
            back--;
            return temp;
        } else {
            throw new Exception("Queue is empty.");
        }
    }

    int dequeueBack() throws Exception {
        if (back > 0) {
            return queue[--back];
        } else {
            throw new Exception("Queue is Empty.");
        }
    }

    void enqueueFront(int value) throws Exception {
        if (back < size) {
            for (int i = back; i > 0; i--) {
                queue[i] = queue[i - 1];
            }
            queue[0] = value;
            back++;
        } else {
            throw new Exception("Queue is Full.");
        }
    }

    boolean isEmpty() {
        return back == 0;
    }

    int size() {
        return back;
    }

    int front() throws Exception {
        if (!isEmpty()) {
            return queue[0];
        }
        throw new Exception("Queue is empty.");
    }

    int back() throws Exception {
        if (!isEmpty()) {
            return queue[back - 1];
        }
        throw new Exception("Queue is empty.");
    }

    void showQueue() {
        for (int i = 0; i < back; i++) {
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Deque dq = new Deque(5);
        dq.enqueue(0);
        dq.enqueue(1);
        dq.enqueue(2);
        dq.enqueueFront(-1);
        dq.dequeue();
        dq.dequeueBack();
        dq.dequeue();
        dq.dequeue();
        dq.showQueue();
    }
}
