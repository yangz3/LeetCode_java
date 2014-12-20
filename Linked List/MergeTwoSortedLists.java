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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        
        // cursors needed to grow the return linkedlist and to traversal the two linked list
        ListNode head = dummy;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                head.next =  new ListNode(head1.val); // build new nodes for growing the return linkedlist
                head = head.next;
                head1 = head1.next;
            }else{
                head.next =  new ListNode(head2.val);
                head = head.next;
                head2 = head2.next;
            }
        }
        
        while(head1 != null){
            head.next = new ListNode(head1.val);
            head = head.next;
            head1 = head1.next;
        }
        
        while(head2 != null){
            head.next = new ListNode(head2.val);
            head = head.next;
            head2 = head2.next;
        }
        
        return dummy.next;
    }
}