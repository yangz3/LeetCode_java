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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null){
            return null;
        }
        int start = 0;
        int end = num.length - 1;
        // three parameters in recursion function
        TreeNode head = buildTree(num, start, end);
        return head;
    }
    
    private TreeNode buildTree(int[] num, int start, int end){
        // base case
        if(start > end){
            return null;
        }
        
        // recursion case
        TreeNode node = new TreeNode(num[(end+start)/2]);
        
        // (divide)
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
        
        // (conquer)
        return node;
    }
    
}
