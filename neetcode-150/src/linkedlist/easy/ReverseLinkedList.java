package linkedlist.easy;

import linkedlist.ListNode;

/*
 * Use 3 consecutive pointers N1 N2 N3
 * Reverse linkages by set N2.Next to N1
 * Move all 3 pointers forward till list end
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode node1 = null;
        ListNode node2 = head;
        ListNode node3 = head.next;

        while (node3 != null) {
            node2.next = node1;
            node1 = node2;
            node2 = node3;
            node3 = node3.next;
        }

        node2.next = node1;
        head = node2;

        return head;
    }
}
