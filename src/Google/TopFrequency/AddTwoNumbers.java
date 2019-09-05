package Google.TopFrequency;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = linkedListToNumber(l1) + linkedListToNumber(l2);
        return numberToLinkedList(sum);
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
