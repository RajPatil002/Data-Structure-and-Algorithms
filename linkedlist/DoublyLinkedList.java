package linkedlist;

class DoublyNode<T> {
    private DoublyNode<T> prev;
    T value;
    private DoublyNode<T> next;

    DoublyNode(T value) {
        this.value = value;
    }

    DoublyNode(T value, DoublyNode<T> next, DoublyNode<T> prev) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }

    void setNext(DoublyNode<T> next) {
        this.next = next;
    }

    DoublyNode<T> getNext() {
        return next;
    }

    boolean hasNext() {
        return next != null;
    }

    void setPrev(DoublyNode<T> prev) {
        this.prev = prev;
    }

    DoublyNode<T> getPrev() {
        return prev;
    }

    boolean hasPrev() {
        return prev != null;
    }
}

public class DoublyLinkedList<T> {
    private DoublyNode<T> head, end;

    private void link(T value, DoublyNode<T> next, DoublyNode<T> prev) {
        DoublyNode<T> temp = new DoublyNode<T>(value, next, prev);
        if (next != null)
            next.setPrev(temp);
        if (prev != null)
            prev.setNext(temp);
    }

    void insert(T value) {
        if (isEmpty()) {
            head = end = new DoublyNode<T>(value);
        } else {
            link(value, end.getNext(), end);
            end = end.getNext();
        }
    }

    private DoublyNode<T> traversNode(int index) {
        DoublyNode<T> temp = head;
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

    void insert(T value, int index) {
        if (index <= 0) {
            insertFront(value);
        } else {
            DoublyNode<T> prev = traversNode(index);
            if (!prev.hasNext()) {
                insert(value);
            } else {
                link(value, prev.getNext(), prev);
            }
        }
        showList();
    }

    void insertFront(T value) {
        link(value, head, head.getPrev());
        head = head.getPrev();
    }

    void unlink(DoublyNode<T> delete) {
        DoublyNode<T> tempnext = delete.getNext();
        DoublyNode<T> tempprev = delete.getPrev();
        if (tempnext != null)
            tempnext.setPrev(tempprev);
        if (tempprev != null)
            tempprev.setNext(tempnext);
    }

    T pop() throws Exception {
        T temp = head.value;
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
            DoublyNode<T> prev = traversNode(index);
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
        DoublyNode<T> temp = head;
        int counter = 0;
        while (temp != null) {
            temp = temp.getNext();
            counter++;
        }
        return counter;
    }

    void showList() {
        System.out.println("Updates:");
        DoublyNode<T> temp = head;
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
        DoublyLinkedList<Integer> dl = new DoublyLinkedList<Integer>();
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
