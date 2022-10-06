public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean insert(int value) {

        var newNode = Node.of(value);

        if (isEmpty()) {
            root = newNode;
            return true;
        }

        var currentNode = root;
        while (true) {
            if (value < currentNode.getValue()) {
                if (currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                } else {
                    currentNode.setLeft(newNode);
                    return true;
                }
            } else if (value > currentNode.getValue()) {
                if (currentNode.getRight() != null) {
                    currentNode = currentNode.getRight();
                } else {
                    currentNode.setRight(newNode);
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    public boolean contains(int value) {

        if (isEmpty()) {
            return false;
        }

        var currentNode = root;
        while (true) {
            if (value < currentNode.getValue()) {
                if (currentNode.getLeft() == null) {
                    return false;
                } else {
                    currentNode = currentNode.getLeft();
                }
            } else if (value > currentNode.getValue()) {
                if (currentNode.getRight() == null) {
                    return false;
                } else {
                    currentNode = currentNode.getRight();
                }
            } else {
                return true;
            }
        }

    }

}
