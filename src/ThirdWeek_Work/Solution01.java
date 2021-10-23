/**
 * 第三周作业
 * 姓名：辛逸杰
 * 学号：G20210760020092
 * 题目：合并k个升序链表  23. Merge k Sorted Lists
 *
 */

package ThirdWeek_Work;

import FirstWeek_Work.mergeTwoLists.ListNode;

import java.util.PriorityQueue;

public class Solution01 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a, b)-> (a.val - b.val));
        ListNode gummy = new ListNode(-1);
        ListNode head = gummy;

        for(ListNode p : lists) {
            if (p != null)
                pq.offer(p);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            if (node.next != null)
                pq.offer(node.next);
            head = head.next;
        }
        return gummy.next;
    }
}
