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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return helper(root) != -1;
    }
    
    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int lMax = helper(node.left);
        int rMax = helper(node.right);
        
        if(lMax == -1 || rMax == -1){
            return -1;
        }
        
        if(Math.abs(lMax - rMax) > 1){
            return -1;
        }
        
        return Math.max(lMax,rMax) + 1;
    }
    
}