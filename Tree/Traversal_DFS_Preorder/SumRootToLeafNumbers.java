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
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        helper(root, 0); // pass value to next level. value is without current node's value
        return sum;
    }
    
    public void helper(TreeNode node, int currentSum){
        
        
        if(node.left == null && node.right == null){ // this is a leaf node
            sum += currentSum*10 + node.val;
        }
        
        if(node.left != null){
            helper(node.left, currentSum*10 + node.val);
        }
        
        if(node.right != null){
            helper(node.right, currentSum*10 + node.val);
        }
        
    }
    
}