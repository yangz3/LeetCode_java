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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        
        if(root == null){
            return rst;
        }
        
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            ArrayList<Integer> currentLevel = new ArrayList<Integer>();
            int len = queue.size();
            count++;
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            
            if(count%2 == 0){
                Collections.reverse(currentLevel); // reverse current level's node list
            }
            
            rst.add(currentLevel);
            
        }
        return rst;
        
    }
    
}