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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        
        // pass two list to the recursion function to record solutions
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>(); // final result
        ArrayList<Integer> solution = new ArrayList<Integer>(); // temp solution // neet to retrieve after added up!!!!!
        
        helper(rst, solution, root, sum);
        return rst;
    }
    
    void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> solution, TreeNode node, int sumLeft){
        if(node == null){
            return;
        }
        
        sumLeft = sumLeft - node.val;
        
        if(node.left == null && node.right == null){
            if(sumLeft == 0){
                solution.add(node.val); // add
                rst.add(new ArrayList<Integer>(solution));
                solution.remove(solution.size()-1); // retrieve
            }
            return;
        }
        
        solution.add(node.val); // add
        helper(rst, solution, node.left, sumLeft);
        helper(rst, solution, node.right, sumLeft);
        solution.remove(solution.size()-1); // retrieve
        
    }
}