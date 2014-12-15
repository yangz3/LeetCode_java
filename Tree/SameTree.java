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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean ret;
        ret = helper(p,q);
        return ret;
    }
    
    public boolean helper(TreeNode p, TreeNode q){
        // there are three base cases
        if(p == null && q == null){
            return true;
        }else if(p != null && q != null){
            // divide
            boolean retFromLeft = helper(p.left, q.left);
            boolean retFromRight = helper(p.right, q.right);
            
            // conquer
            return(retFromLeft && retFromRight && (p.val == q.val));
        }
        return false;
    }
    
}