public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0){
            return rst;
        }
        Arrays.sort(S); // only for AC the OJ, not really necessary
        helper(S, temp, rst, 0);
        return rst;
    }
    
    private void helper(int[] S, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> rst, int pos){
        rst.add(new ArrayList<Integer>(temp));
        
        if(pos == S.length){
            return;
        }
        
        for(int i = pos; i < S.length; i++){
            
            temp.add(S[i]);
            helper(S, temp, rst, i+1); // Wrong helper(S, temp, rst, pos+1);
            temp.remove(temp.size() - 1);
        }
    }
}