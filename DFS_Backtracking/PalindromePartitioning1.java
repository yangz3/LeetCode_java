// palindromePartitioning2 is DP problem because it only needs minimum cuts number
public class Solution {
    public List<List<String>> partition(String s) {
        // backtracking
        ArrayList<String> temp = new ArrayList<String>();
        ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>>();
        
        helper(s, temp, rst);
        return rst;
    }
    
    private void helper(String stringLeft, ArrayList<String> temp, ArrayList<ArrayList<String>> rst){
        if(stringLeft.equals("")){
            rst.add(temp);
        }
        
        for(int i = 0; i < stringLeft.length(); i++){
            if(isPalindrome(stringLeft, 0, i)){
                temp.add(stringLeft.substring(0,i+1));
                helper(s.substring(i+1), temp, rst);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String string, int start, int end){
        
    }
    
}