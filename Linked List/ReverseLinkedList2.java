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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        // use dummy node because start node could be the head
        // the we will need startPrev to be the dummy node
        
        // set dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        // use four nodes to segment the original list
        ListNode start = head;
        ListNode startPrev = head;
        ListNode end = head;
        ListNode endNext = head;
        
        for(int i = 0; i < n ; i++){
            end = end.next;
        }
        
        endNext = end.next;
        
        for(int i = 0; i < m - 1; i++){
            startPrev = startPrev.next;
        }
        
        start = startPrev.next;
        
        
        ListNode cur = start.next;
        ListNode prev = start;
        ListNode next;
        
        // reverse the segment and then reverse the head and the tail
        
        for(int i = 0; i < n - m; i++){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        startPrev.next = end;
        start.next = endNext;
        
        return dummy.next;
        
    }
}