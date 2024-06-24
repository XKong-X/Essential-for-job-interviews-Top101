package test1;

/**
 * Created with IntelliJ IDEA.
 * Description: BM6 判断链表中是否有环
 * Author: 行空XKong
 * Date: 2024-06-24
 * Time: 20:13
 * Version:
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        // 方法一（快慢指针）
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        // 代码到这说明链表的某个节点的 next 为 null，返回 false
        return false;
    }
}
