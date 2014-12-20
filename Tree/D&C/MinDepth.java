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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root);
    }
    public int helper(TreeNode node){
        // leaf node is node with both sibling node to be null rather than null node
        if(node.left == null && node.right == null){
            return 1;
        }
        
        //ignore null sibling node by assigning it with a max value
        int leftDepth = node.left == null ?  Integer.MAX_VALUE : helper(node.left);
        int rightDepth = node.right == null ?  Integer.MAX_VALUE : helper(node.right);
        
        return(Math.min(leftDepth,rightDepth) + 1);
    }
    
}