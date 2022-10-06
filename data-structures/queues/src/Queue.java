public class Queue {
    private Node first;
    private Node last;
    private int length;

    private Queue(int value) {
        var newNode = Node.of(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    private Queue() {
        first = null;
        last = null;
        length = 0;
    }

    public static Queue of(int value) {
        return new Queue(value);
    }

    public static Queue empty() {
        return new Queue();
    }

    private boolean queueIsempty() {
        return length == 0
                && first == null
                && last == null;
    }

    private boolean queueHasSingleElement() {
        return length == 1 &&
                first!= null
                && last != null
                && first == last;
    }

    public void print() {
        printFirst();
        printLast();
        printLength();
        printElemnts();
    }

    private void printFirst() {
        System.out.println("First = " + first);
    }

    private void printLast() {
        System.out.println("Last = " + last);
    }

    private void printLength() {
        System.out.println("Length = " + length);
    }

    private void printElemnts() {

        if(queueIsempty()) {
            System.out.println("Queue is empty");
        }

        System.out.println("Elements: ");
        var currentNode = first;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }

    public void enqueue(int value) {
        var newNode = Node.of(value);
        if(queueIsempty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        length ++;
    }

    public Node dequeue() {
        var nodeToRemove = first;
        if(!queueIsempty()) {
            first = first.getNext();
            length--;
        }
        return nodeToRemove;
    }

}
