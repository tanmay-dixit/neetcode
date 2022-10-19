package linkedlist;

import java.util.Arrays;

public class LinkedList {

    private ListNode head;
    private int length;

    public ListNode head() {
        return head;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return head == null && length == 0;

    }

    private void incrementLength() {
        length += 1;
    }

    public ListNode append(int value) {
        ListNode newNode = new ListNode(value);

        if (isEmpty()) {
            head = newNode;
            length = 1;
        } else {
            var temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            incrementLength();
        }

        return head;
    }

    public LinkedList(int[] values) {
        Arrays.stream(values).forEach(this::append);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("List has no elements");
        } else {
            var node = head;
            System.out.println("Length = " + length);
            while (node != null) {
                System.out.print("\t" + node.val);
                node = node.next;
            }
        }
    }

}
