/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        while(l1 != null && l2 != null){
            
            int value = (l1.val + l2.val + carry)%10;
            head.next = new ListNode(value);
            carry = (l1.val + l2.val + carry)/10;
            head = head.next;
            // don't forget move forward the cursor of l1 and l2
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int value = (l1.val + carry)%10;
            head.next = new ListNode(value);
            carry = (l1.val + carry)/10;
            head = head.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int value = (l2.val + carry)%10;
            head.next = new ListNode(value);
            carry = (l2.val + carry)/10;
            head = head.next;
            l2 = l2.next;
        }
        
        // don't forget to check if count is 1 in the end
        if(carry == 1){
            head.next = new ListNode(1);
        }
        return dummy.next;
    }
    
}