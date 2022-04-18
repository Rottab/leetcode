package com.rottab.s0083;

import org.junit.jupiter.api.Test;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode clean = new ListNode(head.val, null);
        ListNode ptr = clean;
        head = head.next;
        while (head != null) {
            if (head.val > clean.val) {
                clean.next = new ListNode(head.val, null);
                clean = clean.next;
            }
            head = head.next;
        }
        return ptr;
    }

    @Test
    public void test1() {
        ListNode n1 = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        ListNode r1 = deleteDuplicates1(n1);
        while (r1 != null) {
            System.out.print(r1.val + " ");
            r1 = r1.next;
        }
        System.out.println();

        ListNode n2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        ListNode r2 = deleteDuplicates1(n2);
        while (r2 != null) {
            System.out.print(r2.val + " ");
            r2 = r2.next;
        }
        System.out.println();
    }


    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode ptr = head;
        while (head.next != null) {
            if (head.val == head.next.val) head.next = head.next.next;
            else head = head.next;
        }
        return ptr;
    }

    @Test
    public void test2() {
        ListNode n1 = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        ListNode r1 = deleteDuplicates2(n1);
        while (r1 != null) {
            System.out.print(r1.val + " ");
            r1 = r1.next;
        }
        System.out.println();

        ListNode n2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        ListNode r2 = deleteDuplicates2(n2);
        while (r2 != null) {
            System.out.print(r2.val + " ");
            r2 = r2.next;
        }
        System.out.println();

        ListNode n3 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, null))));
        ListNode r3 = deleteDuplicates2(n3);
        while (r3 != null) {
            System.out.print(r3.val + " ");
            r3 = r3.next;
        }
        System.out.println();
    }
}
