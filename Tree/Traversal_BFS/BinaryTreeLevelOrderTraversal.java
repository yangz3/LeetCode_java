public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return ret;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size(); // size() rather than length()
            ArrayList<Integer> currentLevel = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode n = q.poll();
                currentLevel.add(n.val);
                
                // check notnull before offer to the queue
                if(n.left != null){
                    q.offer(n.left);
                }
                if(n.right != null){
                    q.offer(n.right);
                }
            }
            ret.add(currentLevel);  
        }
        return ret;
    }
}