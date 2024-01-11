package linkedlist;

class DoublyNode {
    private DoublyNode prev;
    int value;
    private DoublyNode next;

    DoublyNode(int value) {
        this.value = value;
    }

    DoublyNode(int value, DoublyNode next, DoublyNode prev) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }

    void setNext(DoublyNode next) {
        this.next = next;
    }

    DoublyNode getNext() {
        return next;
    }

    boolean hasNext() {
        return next != null;
    }

    void setPrev(DoublyNode prev) {
        this.prev = prev;
    }

    DoublyNode getPrev() {
        return prev;
    }

    boolean hasPrev() {
        return prev != null;
    }
}

public class DoublyLinkedList {
    private DoublyNode head, end;

    private void link(int value, DoublyNode next, DoublyNode prev) {
        DoublyNode temp = new DoublyNode(value, next, prev);
        if (next != null)
            next.setPrev(temp);
        if (prev != null)
            prev.setNext(temp);
    }

    void insert(int value) {
        if (isEmpty()) {
            head = end = new DoublyNode(value);
        } else {
            link(value, end.getNext(), end);
            end = end.getNext();
        }
    }

    private DoublyNode traversNode(int index) {
        DoublyNode temp = head;
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
            DoublyNode prev = traversNode(index);
            if (!prev.hasNext()) {
                insert(value);
            } else {
                link(value, prev.getNext(), prev);
            }
        }
        showList();
    }

    void insertFront(int value) {
        link(value, head, head.getPrev());
        head = head.getPrev();
    }

    void unlink(DoublyNode delete) {
        DoublyNode tempnext = delete.getNext();
        DoublyNode tempprev = delete.getPrev();
        if (tempnext != null)
            tempnext.setPrev(tempprev);
        if (tempprev != null)
            tempprev.setNext(tempnext);
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
        unlink(head);
        head = head.getNext();
    }

    void delete(int index) throws Exception {
        if (index <= 0) {
            delete();
        } else {
            DoublyNode prev = traversNode(index);
            if (prev.hasNext() && index > 0) {
                unlink(prev.getNext());
            } else {
                throw new IndexOutOfBoundsException("List does not have index " + index);
            }
        }
    }

    boolean isEmpty() {
        return head == null;
    }

    int length() {
        DoublyNode temp = head;
        int counter = 0;
        while (temp != null) {
            temp = temp.getNext();
            counter++;
        }
        return counter;
    }

    void showList() {
        System.out.println("Updates:");
        DoublyNode temp = head;
        while (temp != null) {
            System.out.printf(" %d ", temp.value);
            if (temp.hasNext())
                temp = temp.getNext();
            else
                break;
        }
        System.out.println();
        while (temp != null) {
            System.out.printf(" %d ", temp.value);
            if (temp.hasPrev())
                temp = temp.getPrev();
            else
                break;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.insert(10);
        dl.showList();
        dl.insert(20);
        dl.showList();
        dl.delete();
        dl.insert(30, -10);
        dl.insert(40);
        dl.insert(50);
        dl.showList();
        dl.delete(2);
        dl.showList();
        dl.insert(60);
        dl.showList();
        System.out.println(dl.length());
    }

}
