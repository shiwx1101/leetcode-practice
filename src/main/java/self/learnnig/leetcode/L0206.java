package self.learnnig.leetcode;

import java.util.List;

/**
 * 206. 反转链表
 *
 *
 */
public class L0206 {

    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preHead = null;
        ListNode current = head;


        while (current.next != null) {
            ListNode next = current.next;
            current.next = preHead;
            preHead = current;
            current = next;
        }
        current.next = preHead;
        return current;
    }
}
