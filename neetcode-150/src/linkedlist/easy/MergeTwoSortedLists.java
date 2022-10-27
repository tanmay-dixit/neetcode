package linkedlist.easy;

import linkedlist.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            System.out.println("List 1 is empty. Returning List 2");
            return list2;
        }

        if (list2 == null) {
            System.out.println("List 2 is empty. Returning List 1");
            return list1;
        }

        var it1 = list1;
        var it2 = list2;
        System.out.println("it1 initialized to = " + it1);
        System.out.println("it2 initialized to = " + it2);

        ListNode it3;
        if (list1.val <= list2.val) {
            it3 = new ListNode(list1.val);
            it1 = it1.next;
        } else {
            it3 = new ListNode(list2.val);
            it2 = it2.next;
        }
        var list3 = it3;
        System.out.println("it3 initialized to = " + it1);
        System.out.println("list3 initialized to = " + it2);

        while (it1 != null && it2 != null) {
            if (it1.val <= it2.val) {
                it3.next = new ListNode(it1.val);
                it1 = it1.next;
            } else {
                it3.next = new ListNode(it2.val);
                it2 = it2.next;
            }
        }

        if (it1 == null) {
            while (it2 != null) {
                it3.next = new ListNode(it2.val);
                it2 = it2.next;
            }
        } else {
            while (it1 != null) {
                it3.next = new ListNode(it1.val);
                it1 = it1.next;
            }
        }

        return list3;
    }

}