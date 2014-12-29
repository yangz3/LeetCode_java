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
            // inorder traversal
            
            // left
            if(helper(root.left) != true){
                return false;
            }
            
            // root
            if(prev != null && root.val <= prev.val ){
                return false;
            }
            
            prev = root;
            
            // right
            if(helper(root.right) != true){
                return false;
            }
            
            return true;
        }
        
        return true;
    }
}
*/

// iteration solution, more elegant to not use global variable
public class Solution {
    public boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode p = root;
        
        TreeNode pre = null;
        while(!stack.empty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode node = stack.pop();
                if(pre != null && pre.val >= node.val){
                    // when a pre node is used in inorder traversal
                    // pre != null is important to make sure check
                    // the value of node from the second visit node
                    return false;
                }
                pre = node;
                p = node.right;
            }
        }
        return true;
    }
    
}