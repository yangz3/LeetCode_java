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
    /* wrong solution
     public ArrayList<Integer> valList = new ArrayList<Integer>();
     public boolean isSymmetric(TreeNode root) {
     TreeNode p = root;
     Stack<TreeNode> stack = new Stack<TreeNode>();
     while(!stack.isEmpty() || p != null){
     if(p != null){
     stack.push(p);
     p = p.left;
     }else{
     TreeNode node = stack.pop();
     valList.add(node.val);
     p = node.right;
     }
     }
     return checkSymmetric(valList);
     }
     public boolean checkSymmetric(ArrayList<Integer> valList){
     for(int i = 0; i < valList.size()/2; i++){
     if(valList.get(i) != valList.get(valList.size() - 1 - i)){
     return false;
     }
     }
     return true;
     }
     */
    
    /* recursion solution
     public boolean isSymmetric(TreeNode root) {
     if(root == null){
     return true;
     }
     
     return helper(root.left, root.right);
     }
     
     public boolean helper(TreeNode l, TreeNode r){
     if(r == null && l == null){
     return true;
     }
     if(r != null && l != null){
     boolean check1 = helper(l.left, r.right);
     boolean check2 = helper(l.right, r.left);
     
     return(check1 && check2 && l.val==r.val);
     
     }
     
     return false;
     }
     */
    
    // interation solution
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.empty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(left == null && right == null){
                continue;
            }
            else if(left != null && right != null){
                if(right.val != left.val){
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
                stack.push(left.right);
                stack.push(right.left);
            }else{
                return false;
            }
            
        }
        
        return true;
    }
    
    
}