package com.rottab.s0002;

import org.junit.Test;


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

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode current = answer;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int result = sum % 10;

            current.next = new ListNode(result);

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
            current = current.next;
        }
        return answer.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print(" ");
            listNode = listNode.next;
        }
    }
}
