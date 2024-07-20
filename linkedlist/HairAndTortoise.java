package linkedlist;

public class HairAndTortoise {
    static boolean isLoop(LinkedList<Integer> list) throws Exception {
        Node<Integer> hare, tortoise;
        hare = tortoise = list.get(0);
        while (hare != null && tortoise != null) {
            hare = hare.getNext().getNext();
            tortoise = tortoise.getNext();
            if (hare == tortoise) {
                System.out.println(hare.value);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insert(0);
        list.insert(10);
        list.insert(20);
        list.insertFront(30);
        list.insertFront(40);
        list.insert(50, 0);
        list.showList();
        // list.get(5).setNext(list.get(2));
        // list.showList();
        System.out.println(isLoop(list));
    }
}
