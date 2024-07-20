package linkedlist;

/**
 * Node is single element in List
 */
class Node<T> {
    T value;
    private Node<T> next;

    Node(T value) {
        this.value = value;
    }

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }

    Node<T> getNext() {
        return next;
    }

    boolean hasNext() {
        return next != null;
    }
}

public class LinkedList<T> {
    private Node<T> head, end;

    public void insert(T value) {
        if (isEmpty()) {
            head = end = new Node<T>(value);
        } else {
            end.setNext(new Node<T>(value));
            end = end.getNext();
        }
    }

    private Node<T> traverseNodeIndex(int index) {
        Node<T> temp = head;
        int counter = 0;
        while (temp.hasNext()) {
            if (counter >= index - 1) {
                break;
            }
            temp = temp.getNext();
            counter++;
        }
        return temp;
    }

    private Node<T> traverseNodeValue(T value) throws Exception {
        Node<T> temp = head;
        Node<T> counter = null;
        while (temp.hasNext()) {
            Node<T> next = temp.getNext();
            if (next.value == value) {
                counter = temp;
                break;
            }
            temp = next;
        }
        if (counter == null)
            throw new Exception("Value not found");
        return temp;
    }

    public void insert(T value, int index) {
        if (index <= 0) {
            insertFront(value);
        } else {
            Node<T> prev = traverseNodeIndex(index);
            if (!prev.hasNext()) {
                insert(value);
            } else {
                prev.setNext(new Node<T>(value, prev.getNext()));
            }
        }
        showList();
    }

    public void remove(T value) throws Exception {
        if (head.value == value) {
            head = head.getNext();
        } else {
            Node<T> prev = traverseNodeValue(value);
            prev.setNext(prev.getNext().getNext());
        }
    }

    public void insertFront(T value) {
        Node<T> temp = new Node<T>(value);
        temp.setNext(head);
        head = temp;
    }

    public T pop() throws Exception {
        T temp = head.value;
        delete();
        return temp;
    }

    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty.");
        }
        head = head.getNext();
    }

    public void delete(int index) throws Exception {
        if (index == 0) {
            delete();
        } else {
            Node<T> prev = traverseNodeIndex(index);
            System.out.println(prev.hasNext());
            if (prev.hasNext() && index > 0) {
                if (!prev.getNext().hasNext()) {
                    end = prev;
                }
                prev.setNext(prev.getNext().getNext());
            } else {
                throw new IndexOutOfBoundsException("List does not have index " + index);
            }
        }
    }

    public Node<T> get(int index) throws Exception {
        if (index == 0)
            return head;
        else {
            Node<T> prev = traverseNodeIndex(index);
            if (prev.hasNext() && index > 0) {
                return prev.getNext();
            } else {
                throw new IndexOutOfBoundsException("List does not have index " + index);
            }
        }
    }

    public int length() {
        Node<T> temp = head;
        int counter = 0;
        while (temp != null) {
            temp = temp.getNext();
            counter++;
        }
        return counter;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void showList() {
        System.out.println("Updates:");
        Node<T> temp = head;
        while (temp != null) {
            System.out.printf(" %d ", temp.value);
            temp = temp.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(0);
        list.insert(10);
        list.insert(20);
        list.insertFront(30);
        list.insertFront(40);
        list.showList();
        list.remove(20);
        list.insert(50, 3);
        list.showList();
        // list.delete(5);
        list.showList();
        System.out.println(list.length());
        // list.get(4).setNext(list.get(0));
        System.out.println();
        list.showList();
        // list.delete(4);
        // System.out.println("delete");
        // list.showList();
        // System.out.println(list.pop());
        // list.showList();
        // list.insert(70, 5);
        // list.insert(60, 3);
        // list.showList();
    }
}
