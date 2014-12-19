public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return rst;
        }
        
        helper(num, temp, rst);
        return rst;
    }
    private void helper(int[] num, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> rst){
        if(temp.size() == num.length){
            rst.add(new ArrayList<Integer>(temp)); // Wrong: rst.add(temp);
        }
        
        for(int i = 0; i < num.length; i++){
            if(!temp.contains(num[i])){
                temp.add(num[i]);
                helper(num, temp, rst);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
}