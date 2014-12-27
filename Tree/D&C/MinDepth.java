/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* The minimum depth is the number of nodes along the shortest path from the 
 root node down to the nearest *leaf* node.
*/

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root);
    }
    public int helper(TreeNode node){
        if(node == null){
            return Integer.MAX_VALUE;
        }
        
        if(node.left == null && node.right == null){
            return 1;
        }
        
        
        int leftDepth =  helper(node.left);
        int rightDepth =  helper(node.right);
        
        return(Math.min(leftDepth,rightDepth) + 1);
    }
    
}