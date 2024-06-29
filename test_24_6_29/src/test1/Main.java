package test1;

/**
 * Created with IntelliJ IDEA.
 * Description: BM10 两个链表的第一个公共结点
 * Author: 行空XKong
 * Date: 2024-06-29
 * Time: 23:55
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
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // // 方法一（双指针长度比较法）
        // if (pHead1 == null || pHead2 == null) {
        //     return null;
        // }
        // ListNode tmp1 = pHead1;
        // ListNode tmp2 = pHead2;
        // int len1 = 0;
        // int len2 = 0;
        // // 求 len1 长度
        // while (tmp1 != null) {
        //     ++len1;
        //     tmp1 = tmp1.next;
        // }
        // // 求 len2 长度
        // while (tmp2 != null) {
        //     ++len2;
        //     tmp2 = tmp2.next;
        // }
        // // 从头开始找公共节点
        // tmp1 = pHead1;
        // tmp2 = pHead2;
        // if (len1 >= len2) {
        //     int sub = len1 - len2;
        //     while (tmp1 != null && sub > 0) {
        //         tmp1 = tmp1.next;
        //         --sub;
        //     }
        //     if (tmp1 == null) {
        //         return null;
        //     }
        // } else {
        //     int sub = len2 - len1;
        //     while (tmp2 != null && sub > 0) {
        //         tmp2 = tmp2.next;
        //         --sub;
        //     }
        //     if (tmp2 == null) {
        //         return null;
        //     }
        // }
        // while (tmp1 != tmp2) {
        //     tmp1 = tmp1.next;
        //     tmp2 = tmp2.next;
        // }
        // return tmp1;

        // 方法二（双指针连接法）
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode tmp1 = pHead1;
        ListNode tmp2 = pHead2;
        while (tmp1 != tmp2) {
            // 当 tmp 第一次为 null 时，把另一个 pHead 的地址赋给 tmp，之后当 tmp1 和 tmp2 相等时找到公共结点
            tmp1 = tmp1 == null ? pHead2 : tmp1.next;
            tmp2 = tmp2 == null ? pHead1 : tmp2.next;
        }
        return tmp1;
    }
}
