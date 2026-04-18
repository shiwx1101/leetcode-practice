package self.learnnig.leetcode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class L0092 {

    public static class ListNode {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) return head;

        ListNode preHead = new ListNode(-1, head);
        ListNode pre = preHead;
        ListNode current = head;
        int index = 1;
        while (index < left) {
            ListNode next = current.next;
            pre = current;
            current = next;
            index++;
        }

        ListNode linkLeft = pre;
        ListNode linkRight = current;
        pre = null;

        while (index >= left && index < right && current.next != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
            index++;
        }
        ListNode pNext = current.next;
        current.next = pre;
        linkLeft.next = current;
        linkRight.next = pNext;

        return preHead.next;

    }

    //3 5 [1,2]

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        L0092 l0092 = new L0092();
        ListNode node1 = l0092.reverseBetween(node, 2, 4);
        System.out.println(node1);
    }
}
