public class Stack {
    private Node top;
    private int height;

    private Stack(int value) {
        top = Node.of(value);
        height = 1;
    }

    private Stack() {
        top = null;
        height = 0;
    }

    public static Stack empty() {
        return new Stack();
    }

    public static Stack of(int value) {
        return new Stack(value);
    }

    public boolean isEmpty() {
        return height == 0 && top == null;
    }

    public  void print() {
        printTop();
        printHeight();
        printStack();
    }
    private void printTop() {
        System.out.println("Top: " + top);
    }

    private void printHeight() {
        System.out.println("Height: " + height);
    }

    private  void printStack() {
        System.out.println("Elements: ");
        var currentNode = top;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }

    public void push(int value) {
        var newNode = Node.of(value);
        newNode.setNext(top);
        top = newNode;
        height ++;
    }

    public Node pop() {
        var nodeToRemove = top;
        if(!isEmpty()) {
            top = top.getNext();
            nodeToRemove.setNext(null);
            height--;
        }
        return nodeToRemove;
    }

}
