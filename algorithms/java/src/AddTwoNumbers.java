package AddTwoNumbers;

import java.util.HashMap;
import java.util.Map;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            throw new IllegalArgumentException("No two numbers");
        }
        ListNode head = new ListNode(-1);
        ListNode current = head;
        int c =0;
        int a1 =0;
        int a2 =0;
        int sum = 0;
        int s = 0;
        while(l1!=null || l2!=null){
            a1 = l1 == null? 0: l1.val;
            a2 = l2 == null ? 0:l2.val;
            sum = a1 + a2 +c;
            c = sum/10;
            s = sum%10;
            ListNode newNode =  new ListNode(s);
            current.next = newNode;
            current = newNode;
            //当使用while的时候，下一步更新，容易忘记，特别l1,l2不为空才能更新，还有最好写成单独的函数作为跟新。
            if (l1!=null ) l1 = l1.next;
            if (l2!=null ) l2 = l2.next;

        }
        // 容易忘记更新后续进位的地方
        if (c ==1){
            ListNode newNode = new ListNode(1);
            current.next = newNode;
        }
        return head.next;
    }
}