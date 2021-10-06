package FirstWeek_Work.mergeTwoLists;
/**
* 第一周作业第二题：合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode gummy = new ListNode(-1);
        ListNode cur = gummy;
        while(p1 != null && p2 != null) {

            if(p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            }
            else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if(p1 == null) cur.next = p2;
        if(p2 == null) cur.next = p1;
        return gummy.next;
    }
}
