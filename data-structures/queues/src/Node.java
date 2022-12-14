public class Node {

    int value;
    Node next;

    private Node(int value) {
        this.value = value;
        this.next = null;
    }

    public static Node of(int value) {
        return new Node(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
