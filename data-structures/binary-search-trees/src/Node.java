import java.util.Objects;

public class Node {
    private int value;
    private Node right;
    private Node left;

    private Node(int value) {
        this.value = value;
    }

    public static Node of(int value) {
        return new Node(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (value != node.value) return false;
        if (!Objects.equals(right, node.right)) return false;
        return Objects.equals(left, node.left);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        result = 31 * result + (left != null ? left.hashCode() : 0);
        return result;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
