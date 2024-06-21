package test1;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: BM1 反转链表
 * Author: 行空XKong
 * Date: 2024-06-21
 * Time: 18:25
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
    public ListNode ReverseList(ListNode head) {
        // // 方法一（迭代）
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode prev = null;// 前一个节点
        // ListNode cur = head;// 当前节点
        // while (cur != null) {
        //     ListNode curNext = cur.next;// 保存 cur 的下一个节点
        //     cur.next = prev;// 让当前节点的下一个节点指向前一个节点
        //     prev = cur;
        //     cur = curNext;
        // }
        // return prev;// 返回头节点

//         // 方法二（栈）
//         if (head == null || head.next == null) {
//             return head;
//         }
//         Stack<ListNode> stack = new Stack<>();
//         ListNode tmp = head;
//         // 全部入栈
//         while (tmp != null) {
//             stack.push(tmp);
//             tmp = tmp.next;
//         }
//         ListNode newHead = stack.pop();
//         ListNode node = newHead;
//         while (!stack.isEmpty()) {
//             node.next = stack.pop();
//             node = node.next;
//         }
//         node.next = null;// 最后一个节点的 next 不置为 null 会形成环
//         return newHead;

        // 方法三（递归）
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = ReverseList(head.next);// 新的头节点是旧头节点的下一个节点
        head.next.next = head;// 头节点的下一个节点的下一个节点指向头节点，实现两个节点间的翻转
        head.next = null;
        return newHead;
    }
}