/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* recursion solution */
/*
 public class Solution {
 public ArrayList<Integer> preorderTraversal(TreeNode root) {
 ArrayList<Integer> result = new ArrayList<Integer>();
 traverse(root, result);
 return result;
 }
 
 public void traverse(TreeNode root, ArrayList<Integer> result){
 if(root == null){
 return;
 }
 
 result.add(root.val);
 traverse(root.left, result);
 traverse(root.right, result);
 }
 }
 */


public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null){
            return ret;
        }
        
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            ret.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        
        return ret;
    }
}