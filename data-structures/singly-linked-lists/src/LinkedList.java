import java.util.Objects;

public final class LinkedList {

    private Node head;

    private Node tail;

    private int length;

    private LinkedList(final int value) {
        var newNode = Node.of(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public static LinkedList of(final int value) {
        return new LinkedList(value);
    }

    public void print() {
        printHead();
        printTail();
        printLength();
        printElements();
    }

    private void printHead() {
        System.out.println("head: " + head);
    }

    private void printTail() {
        System.out.println("tail: " + tail);
    }

    private void printLength() {
        System.out.println("length: " + length);
    }

    private void printElements() {
        if (listIsEmpty()) {
            System.out.println("This list has zero elements");
            return;
        }

        System.out.println("Elements: ");
        var iterator = head;
        while (iterator != null) {
            System.out.println(iterator.getValue());
            iterator = iterator.getNext();
        }
    }

    private boolean listHasSingleElement() {
        return length == 1;
    }

    private void deleteList() {
        head = null;
        tail = null;
        length = 0;
    }

    private void checkListContainsIndex(final int targetIndex) {
        if (listDoesNotContainIndex(targetIndex)) {
            throw new IndexOutOfBoundsException("Index is not valid");
        }
    }

    private boolean listDoesNotContainIndex(final int targetIndex) {
        return listIsEmpty() || indexIsOutOfBounds(targetIndex);
    }

    private boolean indexIsOutOfBounds(final int targetIndex) {
        return targetIndex >= length || targetIndex < 0;
    }

    private boolean listIsEmpty() {
        return Objects.isNull(head) || length == 0;
    }

    public void append(final int value) {
        var newNode = Node.of(value);
        if (listIsEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        length++;
    }

    public void removeLastElement() {
        if (listHasSingleElement()) {
            deleteList();
        } else {
            var currentNode = head;
            while (!tail.equals(currentNode.getNext())) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
            tail = currentNode;
            length--;
        }
    }

    public void prepend(final int value) {
        var firstNode = Node.of(value);
        if (listIsEmpty()) {
            head = tail = firstNode;
        } else {
            firstNode.setNext(head);
            head = firstNode;
        }
        length++;
    }

    public void removeFirstElement() {

        if (listIsEmpty()) {
            return;
        }

        if (listHasSingleElement()) {
            head = tail = null;
            length--;
        } else {
            head = head.getNext();
            length--;
        }
    }

    public Node get(final int targetIndex) throws IndexOutOfBoundsException {

        checkListContainsIndex(targetIndex);

        var currentNode = head;
        for (int currentIndex = 0; currentIndex < targetIndex; currentIndex++) {
            currentNode = currentNode.getNext();
        }
        System.out.println("Getting : " + currentNode.getValue());
        return currentNode;
    }

    public void set(final int targetIndex, final int targetValue) {

        checkListContainsIndex(targetIndex);

        var currentNode = head;
        for (int currentIndex = 0; currentIndex < targetIndex; currentIndex++) {
            currentNode = currentNode.getNext();
        }

        currentNode.setValue(targetValue);
        System.out.println("Setting value at index: " + targetIndex + " to " + currentNode.getValue());
    }

    public void insert(final int targetIndex, final int targetValue) {
        if (targetIndex == 0) {
            prepend(targetValue);
        } else if (targetIndex == length) {
            append(targetValue);
        } else {
            checkListContainsIndex(targetIndex);
            var currentNode = head;
            var newNode = Node.of(targetValue);
            for (int currentIndex = 0; currentIndex < targetIndex - 1; currentIndex++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            length++;
        }

    }

    public void remove(final int targetIndex) {
        if (targetIndex == 0) {
            removeFirstElement();
        } else if (targetIndex == length - 1) {
            removeLastElement();
        } else {
            checkListContainsIndex(targetIndex);
            var currentNode = head;
            for (int i = 0; i < targetIndex - 1; i++) {
                currentNode = currentNode.getNext();
            }
            var nodeToRemove = currentNode.getNext();
            currentNode.setNext(nodeToRemove.getNext());
            length--;
        }
    }

    public void reverse() {

        if (length < 2) {
            return;
        }

        Node tempNode = null;
        var node1 = head;
        var node2 = head.getNext();

        while (node2 != null) {
            node1.setNext(tempNode);
            tempNode = node1;
            node1 = node2;
            node2 = node2.getNext();
        }
        node1.setNext(tempNode);

        // swap head & tail
        tempNode = head;
        head = tail;
        tail = tempNode;

    }

}