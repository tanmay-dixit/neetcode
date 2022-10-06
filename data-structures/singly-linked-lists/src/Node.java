public final class Node {

    private int value;
    private Node next;

    private Node() {
        setNext(null);
    }

    private Node(int value) {
        setValue(value);
        setNext(null);
    }

    public static Node of(int value) {
        return new Node(value);
    }

    public static Node empty() {
        return new Node();
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        result = prime * result + value;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Node other = (Node) obj;
        if (next == null) {
            if (other.next != null) {
                return false;
            }
        } else if (!next.equals(other.next)) {
            return false;
        }

        return value == other.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}