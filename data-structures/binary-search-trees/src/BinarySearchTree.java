import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
            if (value < currentNode.value()) {
                if (currentNode.left() != null) {
                    currentNode = currentNode.left();
                } else {
                    currentNode.setLeft(newNode);
                    return true;
                }
            } else if (value > currentNode.value()) {
                if (currentNode.right() != null) {
                    currentNode = currentNode.right();
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
            if (value < currentNode.value()) {
                if (currentNode.left() == null) {
                    return false;
                } else {
                    currentNode = currentNode.left();
                }
            } else if (value > currentNode.value()) {
                if (currentNode.right() == null) {
                    return false;
                } else {
                    currentNode = currentNode.right();
                }
            } else {
                return true;
            }
        }
    }

    public List<Integer> bfs() {
        var currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        var result = new ArrayList<Integer>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {

            currentNode = queue.remove();
            result.add(currentNode.value());

            if (currentNode.hasLeft()) {
                queue.add(currentNode.left());
            }
            if (currentNode.hasRight()) {
                queue.add(currentNode.right());
            }

        }

        return result;
    }

    public List<Integer> dfsPreOrderIterative() {

        if (isEmpty()) {
            return Collections.emptyList();
        }

        var currentNode = root;

        var stack = new Stack<Node>();
        stack.push(root);

        var result = new ArrayList<Integer>();

        while (!stack.isEmpty()) {

            result.add(currentNode.value());

            if (currentNode.hasLeft()) {
                if (currentNode.hasRight()) {
                    stack.push(currentNode.right());
                }
                currentNode = currentNode.left();
            } else {
                currentNode = stack.pop();
                if (currentNode == root) {
                    break;
                }
            }

        }
        return result;
    }

    public List<Integer> dfsPreOrderRecursive() {

        if (isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        class PreOrderTraverse {

            public PreOrderTraverse(Node currentNode) {
                result.add(currentNode.value());

                if (currentNode.hasLeft()) {
                    new PreOrderTraverse(currentNode.left());
                }

                if (currentNode.hasRight()) {
                    new PreOrderTraverse(currentNode.right());
                }
            }
        }

        new PreOrderTraverse(root);

        return result;
    }

    public List<Integer> dfsPostOrderRecursive() {

        if (isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        class PostOrderTraverse {

            public PostOrderTraverse(Node currentNode) {

                if (currentNode.hasLeft()) {
                    new PostOrderTraverse(currentNode.left());
                }

                if (currentNode.hasRight()) {
                    new PostOrderTraverse(currentNode.right());
                }

                result.add(currentNode.value());

            }
        }

        new PostOrderTraverse(root);

        return result;

    }

    public List<Integer> dfsInOrderRecursive() {

        if (isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        class InOrderTraverse {

            public InOrderTraverse(Node currentNode) {

                if (currentNode.hasLeft()) {
                    new InOrderTraverse(currentNode.left());
                }

                result.add(currentNode.value());

                if (currentNode.hasRight()) {
                    new InOrderTraverse(currentNode.right());
                }

            }
        }

        new InOrderTraverse(root);

        return result;

    }

}