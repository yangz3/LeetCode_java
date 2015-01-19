/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) { // attention: random can point to null
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;
        // use two cursor, one is head to traverse nodes from the old list
        // the other is to traverse new nodes generated
        RandomListNode temp = head.next;
        while (head != null) {
            temp = head.next;
            
            if(temp != null){
                head.next = temp.next;
            }
            
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            
            head = head.next;
        }
        return newHead;
    }
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
    
}