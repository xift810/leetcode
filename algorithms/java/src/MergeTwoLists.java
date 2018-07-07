

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 ==null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int curval =0;
        //曾经试过直接把l1,l2在后面拼接，代码减少，也能通过。
        //但是实际例子当中，不应该把返回的对象直接和参数对线关联。
        while (l1!=null || l2!=null){
            if (l1 == null){
                curval = l2.val;
                l2 = l2.next;
            } else if (l2 == null){
                curval = l1.val;
                l1 = l1.next;
            } else if (l1.val < l2.val){
                curval = l1.val;
                l1 = l1.next;
            } else {
                curval = l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(curval);
            cur.next = newNode;
            cur = newNode;
        }
        return dummy.next;
    }
}