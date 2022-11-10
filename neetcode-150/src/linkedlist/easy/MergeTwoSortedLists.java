package linkedlist.easy;

import linkedlist.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists_Iterative(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode temp;
        var head = list1.val <= list2.val ? list1 : list2;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp = list1.next;
                list1.next = list2;
                list1 = temp;
            } else {
                temp = list2.next;
                list2.next = list1;
                list2 = temp;
            }
        }

        if (list1 == null) {

        } else {

        }

        return head;
    }

    public ListNode mergeTwoLists_Recursive(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
        }

        return list1.val <= list2.val ? list1 : list2;

    }

}