package test2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description: BM5 合并k个已排序的链表
 * Author: 行空XKong
 * Date: 2024-06-23
 * Time: 22:11
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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // // 方法一（优先级队列）
        // Queue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);// 重载比较方法，描述比较规则
        // // 把链表的第一个元素加入队列（不能一次全部加入，会导致堆溢出）
        // for (ListNode head : lists) {
        //     if (head != null) {
        //         queue.add(head);
        //         head = head.next;
        //     }
        // }
        // ListNode newHead = new ListNode(-1);
        // ListNode node = newHead;
        // while (!queue.isEmpty()) {
        //     ListNode head = queue.poll();
        //     node.next = head;
        //     node = node.next;
        //     if (head.next != null) {
        //         queue.add(head.next);
        //     }
        // }
        // // 去掉表头
        // return newHead.next;

        // 方法二（归并排序）
        if (lists.size() == 0) {
            return null;
        }
        return divideMerge(lists, 0, lists.size() - 1);
    }

    // 划分区间
    private ListNode divideMerge(ArrayList<ListNode> lists, int left, int right) {
        // // 这里是用来处理 lists 内容为空时的情况，已在主函数进行处理
        // if (left > right) {
        //     return null;
        // }
        // else
        if (left == right) {
            return lists.get(left);
        }
        // 计算中间值
        int mid = (left + right) / 2;
        return Merge(divideMerge(lists, left, mid), divideMerge(lists, mid + 1, right));
    }

    // 合并链表
    private ListNode Merge(ListNode leftList, ListNode rightList) {
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }
        ListNode newHead = new ListNode(-1);
        ListNode node = newHead;
        while (leftList != null && rightList != null) {
            if (leftList.val <= rightList.val) {
                node.next = leftList;
                leftList = leftList.next;
            } else {
                node.next = rightList;
                rightList = rightList.next;
            }
            node = node.next;
        }
        if (leftList != null) {
            node.next = leftList;
        }
        if (rightList != null) {
            node.next = rightList;
        }
        // 去掉表头
        return newHead.next;
    }
}
