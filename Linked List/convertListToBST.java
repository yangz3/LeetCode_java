/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// solution1 need to trace the list O = O(Nlog(N))
public class Solution {
    
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        // pase head node of the list and also its length to the recursion function
        TreeNode root = helper(head, size);
        return root;
    }
    
    private TreeNode helper(ListNode head, int size){
        if (size == 0){
            return null;
        }
        
        TreeNode left = helper(head, (size)/2); // length of the left half list
        
        for(int i = 0; i < size/2; i++){
            head = head.next;
        }
        TreeNode cur = new TreeNode(head.val);
        head = head.next;
        
        TreeNode right = helper(head, (size) - (size/2) - 1); // imp to get the correct length of the right half list
        
        cur.left = left;
        cur.right = right;
        return cur;
    }
    
    private int getVal(ListNode head, int offset){
        ListNode cur = head;
        for(int i = 0; i <= offset; i++){
            cur = cur.next;
        }
        return cur.val;
    }
    
    private int getSize(ListNode head){
        ListNode cur = head;
        if(head == null){
            return 0;
        }
        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        return len;
    }
}


// solution2
public class Solution {
    
    // use inorder traversal to construct the tree, we don't need to waste any time
    // to trace down the list therefore the O is O(n)
    private ListNode current;
    
    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int size;
        
        current = head;
        size = getListLength(head);
        
        return sortedListToBSTHelper(0, size - 1);
    }
    
    public TreeNode sortedListToBSTHelper(int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end)/2;
        TreeNode left = sortedListToBSTHelper(start, mid-1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(mid+1, end);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
}