package linkedlist.easy;

import java.util.HashSet;

import linkedlist.ListNode;

public class HasCycle {

    public boolean hasCycle1(ListNode head) {
        var currentNode = head;
        var uniqueNodes = new HashSet<ListNode>();
        while (currentNode != null) {
            if (uniqueNodes.contains(currentNode)) {
                return true;
            }
            uniqueNodes.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        var slow = head;
        var fast = head.next;

        while (slow != null && fast != null) {

            if (fast == slow) {
                return true;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            } else {
                fast = fast.next;
            }
        }

        return false;

    }

}
