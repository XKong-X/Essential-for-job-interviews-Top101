package test1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-28
 * Time: 23:45
 * Version:
 */

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // // 方法一（快慢指针）
        // if (pHead == null) {
        //     return pHead;
        // }
        // ListNode slow = pHead;
        // ListNode fast = pHead;
        // // fast 先走 k 步
        // while (k > 0) {
        //     if (fast == null) {
        //         return null;
        //     }
        //     fast = fast.next;
        //     --k;
        //     // fast 为 null 说明 k 大于链表长度，返回 null 即可
        // }
        // // slow 和 fast 同步走，fast 为 null 时，slow 就是最后k个结点的起点
        // while (fast != null) {
        //     slow = slow.next;
        //     fast = fast.next;
        // }
        // return slow;

        // 方法二（先找长度再找最后k（扩展思路））
        if (pHead == null) {
            return pHead;
        }
        // 求链表长度
        int len = 0;
        ListNode tmp = pHead;
        while (tmp != null) {
            tmp = tmp.next;
            ++len;
        }
        if (len < k) {
            return null;
        }
        tmp = pHead;
        int sub = len - k;
        while (sub > 0) {
            --sub;
            tmp = tmp.next;
        }
        return tmp;
    }
}
