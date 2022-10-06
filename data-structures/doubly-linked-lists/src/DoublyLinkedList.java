public final class DoublyLinkedList {

    Node head;
    Node tail;
    int length;

    private DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        length = 0;
    }

    private DoublyLinkedList(int value) {
        Node newNode = Node.of(value);
        this.tail = newNode;
        this.head = newNode;
        length = 1;
    }

    @Override
    public String toString() {
        return "DoublyLinkedList [head=" + head +
                ", length=" + length +
                ", tail=" + tail + "]";
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public static DoublyLinkedList of(int value) {
        return new DoublyLinkedList(value);
    }

    public static DoublyLinkedList empty() {
        return new DoublyLinkedList();
    }

    public void print() {
        printHead();
        printTail();
        printLength();
        printElements();
    }

    private void printHead() {
        System.out.println("Head = " + head);
    }

    private void printTail() {
        System.out.println("Tail = " + tail);
    }

    private void printLength() {
        System.out.println("Length = " + length);
    }

    private void printElements() {
        System.out.println("Elements: ");

        var currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }

    private boolean listIsEmpty() {
        return length == 0 && head == null && tail == null;
    }

    private boolean listHasSingleElement() {
        return length == 1 && head == tail;
    }

    public void append(int value) {
        var newNode = Node.of(value);
        if (listIsEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        length++;
    }

    public void removeLast() {
        if (listIsEmpty()) {
            return;
        }

        if (listHasSingleElement()) {
            tail = null;
            head = null;
        } else {
            var temp = tail;
            tail = tail.getPrevious();
            tail.setNext(null);
            temp.setPrevious(null);
        }
        length--;
    }

    public void prepend(int value) {
        var newNode = Node.of(value);
        if (listIsEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        length++;
    }

    public void removeFirst() {
        if (listIsEmpty()) {
            return;
        }

        if (listHasSingleElement()) {
            head = null;
            tail = null;
        } else {
            var secondNode = head.getNext();
            secondNode.setPrevious(null);
            head.setNext(null);
            head = secondNode;
        }
        length--;
    }

    public Node getNode(int index) {

        if (listDoesNotContainsIndex(index)) {
            return null;
        }

        if (index <= length / 2) {
            return getNodeFromFirst(index);
        } else {
            return getNodeFromLast(index);
        }
    }

    public Node getNodeFromFirst(int index) {
        var currentNode = head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            currentNode = currentNode.getNext();
        }
        System.out.println("Returning: " + currentNode.getValue());
        return currentNode;
    }

    public Node getNodeFromLast(int index) {
        var currentNode = tail;
        for (int currentIndex = length - 1; currentIndex > index; currentIndex--) {
            currentNode = currentNode.getPrevious();
        }
        System.out.println("Returning: " + currentNode.getValue());
        return currentNode;
    }

    private boolean listDoesNotContainsIndex(int index) {
        return listIsEmpty() && indexIsOutOfBounds(index);
    }

    private boolean indexIsOutOfBounds(int index) {
        return index >= length || index < 0;
    }

    public void set(int targetIndex, int targetValue) {

        if (listDoesNotContainsIndex(targetIndex)) {
            return;
        }

        var node = getNode(targetIndex);
        if (node != null) {
            node.setValue(targetValue);
        }
    }

    public void insert(int targetIndex, int targetValue) {
        if (indexIsOutOfBounds(targetIndex)) {
            return;
        } else if (targetIndex == 0) {
            prepend(targetValue);
        } else if (targetIndex == length) {
            append(targetValue);
        } else {
            var currentNode = getNodeFromFirst(targetIndex - 1);
            var newNode = Node.of(targetValue);
            newNode.setPrevious(currentNode);
            newNode.setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(newNode);
            currentNode.setNext(newNode);
            length++;
        }
    }

    public void remove(int index) {
        if (listDoesNotContainsIndex(index)) {
            return;
        } else if (index == 0) {
            removeFirst();
        } else if (index == length - 1) {
            removeLast();
        } else {
            var beforeNode = getNode(index - 1);
            var nodeToRemove = beforeNode.getNext();
            var afterNode = nodeToRemove.getNext();

            beforeNode.setNext(afterNode);
            afterNode.setPrevious(beforeNode);

            nodeToRemove.setNext(null);
            nodeToRemove.setPrevious(null);

            length--;
        }
    }

}
