package leetcode;

import java.util.*;

public class RemoveNthNodeFromEndofList {
    static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        ListNode nextNode = head.next;
        while (!Objects.isNull(nextNode)) {
            stack.push(nextNode);
            nextNode = nextNode.next;
        }
        for (int i = 1; i < n; i++) {
            stack.pop();
        }
        ListNode targetNode = stack.pop();
        if (stack.isEmpty()) {
            return targetNode.next;
        }
        ListNode beforeNode = stack.pop();
        beforeNode.next = targetNode.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        RemoveNthNodeFromEndofList main = new RemoveNthNodeFromEndofList();
        main.removeNthFromEnd(head, n);

    }
}
