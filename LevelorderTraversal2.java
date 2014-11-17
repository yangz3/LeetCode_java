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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return ret;
        }
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int currentLevelLength = queue.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < currentLevelLength; i++){
                TreeNode n = queue.poll();
                temp.add(n.val);
                
                // do not forget
                if(n.left != null){
                    queue.offer(n.left);
                }
                if(n.right != null){
                    queue.offer(n.right);
                }
            }
            ret.add(0,temp);
        }
        
        return ret;
        
    }
}