/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode mark1;
    TreeNode mark2;
    TreeNode pre;
    
    public void recoverTree(TreeNode root) {
        
        helper(root);
        if(mark1 != null && mark2 != null){
            int tmp = mark1.val;
            mark1.val = mark2.val;
            mark2.val = tmp;
        }
    }
    
    public void helper(TreeNode node){ // inorder traversal
        if(node == null){
            return;
        }
        
        helper(node.left);
        
        if(pre!= null && pre.val > node.val){
            // when a pre node is used in inorder traversal
            // pre != null is important to make sure check
            // the value of node from the second visit node
            if(mark1 != null){ // if mistack appears more than once (twice), previous mistake's father node and current mistake's child node need to be exchanged.
                
                mark2 = node;
            }else{ // if the mistake appears only once, only the pre and the node need to be exchange
                mark1 = pre;
                mark2 = node;
            }
        }
        pre = node;
        
        helper(node.right);
    }
    
    
}