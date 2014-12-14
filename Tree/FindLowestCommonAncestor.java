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
    
    public TreeNode getAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null){
            return null;
        }
        return helper(root, node1, node2);
    }
    
    private TreeNode helper(TreeNode root, TreeNode node1, TreeNode node2){
        if(root == null || root == node1 || root == node2){
            return root;
        }
        
        // Divide
        TreeNode left = helper(root.left, node1, node2);
        TreeNode right = helper(root.right, node1, node2);
        
        // Conquer
        if(left != null && right != null){ // every root is posible to be the LCA
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        
        return null;
    }
}