package linkedlist;

/**
 * Node is single element in List
 */
class Node {
    int value;
    private Node next;

    Node(int value) {
        this.value = value;
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    Node getNext() {
        return next;
    }

    boolean hasNext() {
        return next != null;
    }
}

public class LinkedList {
    private Node head, end;

    void insert(int value) {
        if (isEmpty()) {
            head = end = new Node(value);
        } else {
            end.setNext(new Node(value));
            end = end.getNext();
        }
    }

    private Node traversNode(int index) {
        Node temp = head;
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

    void insert(int value, int index) {
        if (index <= 0) {
            insertFront(value);
        } else {
            Node prev = traversNode(index);
            if (!prev.hasNext()) {
                insert(value);
            } else {
                prev.setNext(new Node(value, prev.getNext()));
            }
        }
        showList();
    }

    void insertFront(int value) {
        Node temp = new Node(value);
        temp.setNext(head);
        head = temp;
    }

    int pop() throws Exception {
        int temp = head.value;
        delete();
        return temp;
    }

    void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty.");
        }
        head = head.getNext();
    }

    void delete(int index) throws Exception {
        if (index == 0) {
            delete();
        } else {
            Node prev = traversNode(index);
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

    int length() {
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            temp = temp.getNext();
            counter++;
        }
        return counter;
    }

    boolean isEmpty() {
        return head == null;
    }

    void showList() {
        System.out.println("Updates:");
        Node temp = head;
        while (temp != null) {
            System.out.printf(" %d ", temp.value);
            temp = temp.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.insert(0);
        list.insert(10);
        list.insert(20);
        list.insertFront(30);
        list.insertFront(40);
        list.insert(50, 0);
        list.delete(0);
        list.showList();
        list.delete(4);
        System.out.println("delete");
        list.showList();
        System.out.println(list.pop());
        list.showList();
        list.insert(70, 5);
        list.insert(60, 3);
        list.showList();
    }
}
