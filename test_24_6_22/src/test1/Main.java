package test1;

/**
 * Created with IntelliJ IDEA.
 * Description: BM2 链表内指定区间反转
 * Author: 行空XKong
 * Date: 2024-06-22
 * Time: 23:52
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
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // // 方法一（迭代）
        // if (head.next == null) {
        //     return head;
        // }
        // // 给链表增加一个头节点
        // ListNode newHead = new ListNode(-1);
        // newHead.next = head;
        // ListNode prev = newHead;// 这里不能为 null 否则会空指针异常
        // ListNode cur = head;
        // // 找到要翻转的区间的起点
        // for (int i = 1; i < m; ++i) {
        //     prev = cur;
        //     cur = cur.next;
        // }
        // // 完成指定区间内的翻转
        // for (int i = m; i < n; ++i) {
        //     ListNode curNext = cur.next;
        //     cur.next = curNext.next;
        //     // System.out.println(cur == prev.next);// 第二次会输出 false 说明 cur != prev.next,因此不能用 cur
        //     curNext.next = prev.next;// prev 不会跟随 cur 往后移动
        //     prev.next = curNext;
        // }
        // // 返回时去掉表头
        // return newHead.next;


        // 方法二（递归）
        // 递归找到起点
        if (m == 1) {
            return reverse(head, n);
        }
        // 缩小区间
        ListNode node = reverseBetween(head.next, m - 1, n - 1);
        head.next = node;// 拼接
        return head;
    }

    private ListNode tmp;

    // 递归缩小范围到两个节点
    private ListNode reverse(ListNode head, int n) {
        if (n == 1) {
            // 记录 head 的下一个节点
            tmp = head.next;
            return head;
        }
        // 缩小区间
        ListNode node = reverse(head.next, n - 1);
        head.next.next = head;// 指向前一个节点
        head.next = tmp;
        return node;
    }
}
