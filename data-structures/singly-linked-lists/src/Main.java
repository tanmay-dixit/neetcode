public class Main {
    public static void main(final String[] args) {

        var list = LinkedList.of(4);

        list.append(5);
        list.append(6);
        list.append(7);

        list.prepend(3);
        list.prepend(2);
        list.prepend(1);

        list.get(0);
        list.get(1);
        list.get(2);
        list.get(3);
        list.get(4);
        list.get(5);
        list.get(6);

        // list.set(0, 7);
        // list.set(1, 6);
        // list.set(2, 5);
        // list.set(3, 4);
        // list.set(4, 3);
        // list.set(5, 2);
        // list.set(6, 1);
        list.reverse();
        list.print();

        // list.insert(0, 1);
        // list.insert(1, 2);
        // list.insert(2, 3);
        // list.insert(3, 4);
        // list.insert(4, 5);
        // list.insert(5, 6);
        // list.insert(6, 7);
        // list.print();

        // list.removeLastElement();
        // list.print();

        // list.removeLastElement();
        // list.print();

        // list.removeLastElement();
        // list.print();

        // list.removeFirstElement();
        // list.print();

        // list.removeFirstElement();
        // list.print();

        // list.removeFirstElement();
        // list.print();

        // list.removeFirstElement();
        // list.print();

    }
}