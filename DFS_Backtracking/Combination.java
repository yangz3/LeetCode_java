public class Solution {
    // Combination is of subset recursion form and of permutation rst.add() form
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        
        helper(n, 1, temp, rst, k);
        return rst;
    }
    
    private void helper(int n, int pos, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> rst, int k){
        if(temp.size() == k){
            rst.add(new ArrayList<Integer>(temp));
        }
        
        for(int i = pos; i <= n; i++){
            if(!temp.contains(i)){
                temp.add(i);
            }
            helper(n, i+1, temp, rst, k);
            temp.remove(temp.size() - 1);
        }
    }
    
}