/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// set prev, curr pointer
// push root while stack is not empty
// peek stack as curr
// three situations
// prev = curr

public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null; // previously traversed node
        TreeNode curr = root;
        
        if (root == null) {
            return result;
        }
        
        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) { // go left hard
                    stack.push(curr.left);
                } else if (curr.right != null) { // go right only when left is null
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) { // traverse up the tree from the left (middle step, we want to go right one step and then go left hard again)
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else { // reach the left most node or there is no right node when traverse up from the left(prev=curr) or traverse up the tree from the right (this is a root whose left and right have been added already)
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        
        return result;
    }
}