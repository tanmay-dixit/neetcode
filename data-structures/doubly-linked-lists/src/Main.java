public class Main {
    public static void main(String[] args) {

        var list = DoublyLinkedList.of(2);

        list.append(3);

        list.removeLast();

        list.prepend(1);

        list.prepend(0);
        list.append(3);
        list.print();

        list.removeFirst();
        list.print();

        list.getNode(1);
        list.getNode(2);

        list.set(2, 1000);
        list.print();

        list.insert(2, 22);
        list.print();

    }
}