public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(candidates);
        
        helper(temp, rst, candidates, target, 0);
        return rst;
    }
    
    private void helper(ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> rst, int[] candidates, int targetLeft, int pos){
        if(targetLeft == 0){
            rst.add(new ArrayList<Integer>(temp));
        }
        int prev = -1;
        for(int i = pos; i < candidates.length; i++){
            if(candidates[i] <= targetLeft){
                temp.add(candidates[i]);
                helper(temp, rst, candidates, targetLeft - candidates[i], i); // it is i rather than i + 1 to allow same element being used multiple times
                temp.remove(temp.size() - 1);
                
            }
        }
    }
}