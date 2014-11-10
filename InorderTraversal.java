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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> lst = new ArrayList<Integer>();
        
        if(root == null)
            return lst;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        //define a pointer to track nodes
        TreeNode p = root;
        
        while(!stack.empty() || p != null){
            
            // go left hard first
            if(p != null){
                stack.push(p);
                p = p.left;
                
            // if cannot go left anymore
            // 1. pop stack, 2. process the node 3.p points to the node.right
            }else{
                TreeNode t = stack.pop();
                lst.add(t.val);
                p = t.right;
            }
        }
        
        
        return lst;
    }
    
}