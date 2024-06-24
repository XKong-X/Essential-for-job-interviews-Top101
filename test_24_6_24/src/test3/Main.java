package test3;

/**
 * Created with IntelliJ IDEA.
 * Description: BM7 链表中环的入口结点
 * Author: 行空XKong
 * Date: 2024-06-24
 * Time: 22:16
 * Version:
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 方法一（快慢指针）
        ListNode slow = func(pHead);
        if (slow == null) {
            return null;
        }
        // 当 slow 和 fast 相遇时，slow 才走完链表的一半路程；因此，让 fast 从头走到相遇即是环的入口
        ListNode fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 判断是否有环
    private ListNode func(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 由于是从同一个地方开始像后走，因此需要先走再判断
            if (slow == fast) {
                return slow;
            }
        }
        // 代码到这说明链表的某个节点的 next 为 null，没有环，返回 null
        return null;
    }
}
