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
    public void flatten(TreeNode root) {
        Stack<TreeNode> toVisit = new Stack<TreeNode>();
        if(root==null) return;
        toVisit.push(root);
        
        TreeNode prev = null;
        while(!toVisit.isEmpty()){
            
            // pop from stack and deal with it
            TreeNode cur = toVisit.pop();
            if(prev!=null){
                prev.left=null;
                prev.right = cur;
                //cur.left = prev // not a double linked list
            }
            prev=cur;
            
            // push back to stack for later iteration, pre-order manner
            if(cur.right!=null)
                toVisit.push(cur.right);
            if(cur.left!=null)
                toVisit.push(cur.left);
            
        }
        
    }
}