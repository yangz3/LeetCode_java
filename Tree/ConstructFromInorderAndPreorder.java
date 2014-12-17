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
    
    // find the position of a node from Pre Array in Inorder Array
    private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
    
    // the principle is: root's left/right subtree is on the left/right side of the root node in the inorder array
    // preorder array is for locating the root nodes
    // the distance between next root and current node can be found in inorder array which are
    // inend - position + 1 or position - instart - 1
    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
                                 int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findPosition(inorder, instart, inend, preorder[prestart]);
        
        root.left = myBuildTree(inorder, instart, position - 1,
                                preorder, prestart + 1, prestart + (position - instart));// next left root is in prestart which is current prestart + 1
        root.right = myBuildTree(inorder, position + 1, inend,
                                 preorder, preend - (inend - position) + 1, preend); // next right root is in prestart which is current preend - (inend - position) + 1
        return root;
    }
    
    
    
}