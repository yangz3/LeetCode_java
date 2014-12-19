public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        if(num == null || num.length ==0){
            return rst;
        }
        Arrays.sort(num);
        helper(num, temp, rst, visited);
        return rst;
    }
    
    private void helper(int[] num, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> rst, int[] visited){
        if(temp.size() == num.length){
            rst.add(new ArrayList<Integer>(temp));
        }
        
        for(int i=0; i< num.length; i++){
            if(visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)){
                continue;
            }
            
            visited[i] = 1;
            temp.add(num[i]);
            helper(num, temp, rst, visited);
            temp.remove(temp.size() - 1);
            visited[i] = 0;
        }
    }
    
}