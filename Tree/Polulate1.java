/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        // initialize the two dummy nodes
        TreeLinkNode parent = root;
        TreeLinkNode next = parent.left;
        while (parent != null && next != null) {
            TreeLinkNode prev = null;
            while (parent != null) {
                if (prev == null) {
                    prev = parent.left;
                } else {
                    // traverse from upper level to lower level
                    prev.next = parent.left;
                    prev = prev.next;
                }
                prev.next = parent.right;
                prev = prev.next;
                parent = parent.next;
            }
            
            // traverse along the left side of the tree
            parent = next;
            next = parent.left;
        }
    }
    
}