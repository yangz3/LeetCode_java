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
    /* iteration solution fails. Cannot retrieve currentSum!!!
     if we need to record a value relative to the path, iteration solution cannot retrieve it when going up in the traversal of the tree.
     
     public boolean hasPathSum(TreeNode root, int sum) {
     if(root == null){
     return false;
     }
     
     int currentSum = 0;
     Stack<TreeNode> stack = new Stack<TreeNode>();
     stack.push(root);
     while(!stack.empty()){
     TreeNode node = stack.pop();
     currentSum += node.val;
     
     // check if leaf node
     if(node.left == null && node.right == null){
     if (currentSum == sum){
     return true;
     }
     
     currentSum = 0;
     }
     
     // push to stack
     if(node.left != null){
     stack.push(node.left);
     }
     if(node.right != null){
     stack.push(node.right);
     }
     }
     
     return false;
     
     }
     */
    
    // similar to root to leaf path sum problem
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        
        return helper(root,sum);
    }
    
    public boolean helper(TreeNode node, int sumLeft){
        if(node == null){
            return false;
        }
        
        if(node.left == null && node.right == null){
            if(node.val == sumLeft){
                return true;
            }
        }
        
        boolean leftResult = helper(node.left, sumLeft - node.val);
        boolean rightResult = helper(node.right, sumLeft - node.val);
        
        return (leftResult || rightResult);
        
    }
    
}