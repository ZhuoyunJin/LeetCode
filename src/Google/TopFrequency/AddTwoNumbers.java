package Google.TopFrequency;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode retNode = new ListNode(0);
        ListNode head = retNode;
        int sum;
        int carry = 0;
        while(l1 != null && l2 != null ){
            sum = l1.val + l2.val + carry;
            head.next = new ListNode(sum%10);
            carry = sum/10;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2 != null) {
            while(l2 != null){
                sum = l2.val + carry;
                head.next = new ListNode(sum%10);
                carry = sum/10;
                head = head.next;
                l2 = l2.next;
            }
        } else if (l1 != null){
            while(l1 != null){
                sum = l1.val + carry;
                head.next = new ListNode(sum%10);
                carry = sum/10;
                head = head.next;
                l1 = l1.next;
            }
        }
        if(carry > 0){
            head.next = new ListNode(carry);
        }
        return retNode.next;
    }

    public ListNode numberToLinkedList(int num){
        ListNode head = new ListNode(0);
        if(num == 0) return head;
        ListNode retNode = head;

        int remainder;
        while(num>0){
            remainder = num%10;
            num = num/10;
            head.next = new ListNode(remainder);
            head = head.next;
        }

        return retNode.next;
    }

    public int linkedListToNumber(ListNode head){
        if(head == null) return 0;
        int result = head.val;
        int base = 10;
        head = head.next;
        while(head != null){
            result =  result + base * head.val;
            head = head.next;
            base = base * 10;
        }
        return result;
    }
}
