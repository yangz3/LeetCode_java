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
    // traversal 的解法， 亲力亲为
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root);
    }
    
    private boolean helper(TreeNode root){
        if(root != null){
            if(helper(root.left) != true){
                return false;
            }
            
            if(prev != null && root.val <= prev.val ){
                return false;
            }
            
            prev = root;
            
            if(helper(root.right) != true){
                return false;
            }
            
            return true;
        }
        
        return true;
    }
}