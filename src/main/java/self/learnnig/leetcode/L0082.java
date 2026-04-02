package self.learnnig.leetcode;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 */
public class L0082 {

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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preHead = new ListNode(Integer.MIN_VALUE, head);
        ListNode pivot = preHead;
        ListNode pre = preHead;
        ListNode current = head;
        while (current != null) {
            if ((current.next == null || current.val != current.next.val) && pre.val != current.val) {
                pivot.next = current;
                pivot = current;
            } else {
                pivot.next = null;
            }
            pre = current;
            current = current.next;
        }
        return preHead.next;


    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(1, null);
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode4 = new ListNode(3, null);
        ListNode listNode5 = new ListNode(4, null);
        ListNode listNode6 = new ListNode(4, null);
        ListNode listNode7 = new ListNode(5, null);

        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;
        ListNode listNode = new L0082().deleteDuplicates(listNode1);
        System.out.println(listNode);
    }
}
