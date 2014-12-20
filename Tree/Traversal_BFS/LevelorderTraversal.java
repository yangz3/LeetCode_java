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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return ret;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int currentLength = queue.size(); // wrong queue.length();
            ArrayList<Integer> currentLevel = new ArrayList<Integer>();
            for(int i = 0; i < currentLength; i++){
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                
                // don't forget to pass subnodes to the queue
                if(node.left != null){
                    queue.offer(node.left);
                }
                
                if(node.right != null){
                    queue.offer(node.right);
                }
                
            }
            ret.add(currentLevel);
        }
        return ret;
    }
}