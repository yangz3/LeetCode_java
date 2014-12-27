/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 Given a binary tree, find the maximum path sum.
 The path may start and end at any node in the tree.
 */
public class Solution {
    
    // use a global value, not elegant
    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        helper(root);
        return maxSum;
    }
    
    // divide and conquer, update a global value in recursion
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int maxSumFromLeft = helper(node.left); // divide
        int maxSumFromRight = helper(node.right);
        
        
        maxSum = Math.max(findMax(maxSumFromLeft+node.val, maxSumFromRight+node.val, node.val, maxSumFromRight+node.val+maxSumFromLeft), maxSum);
        
        if(Math.max(maxSumFromLeft, maxSumFromRight) > 0){ // conquer
            return Math.max(maxSumFromLeft, maxSumFromRight) + node.val;
        }else{
            return node.val;
        }
        
    }
    
    public int findMax(int a, int b, int c, int d){
        return Math.max(Math.max(a,b), Math.max(c,d));
    }
}




/*
 public class Solution {
 private class ResultType {
 int singlePath, maxPath;
 ResultType(int singlePath, int maxPath) {
 this.singlePath = singlePath;
 this.maxPath = maxPath;
 }
 }
 
 private ResultType helper(TreeNode root) {
 if (root == null) {
 return new ResultType(0, Integer.MIN_VALUE);
 }
 // Divide
 ResultType left = helper(root.left);
 ResultType right = helper(root.right);
 
 // Conquer
 int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
 singlePath = Math.max(singlePath, 0);
 
 int maxPath = Math.max(left.maxPath, right.maxPath);
 maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
 
 return new ResultType(singlePath, maxPath);
 }
 
 public int maxPathSum(TreeNode root) {
 ResultType result = helper(root);
 return result.maxPath;
 }
 }
 */