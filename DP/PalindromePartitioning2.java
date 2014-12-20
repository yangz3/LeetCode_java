// PalindromePartitioning1 is backtracking problem because it needs a list of all results

public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] cut = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            cut[i] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome(s, j, i) && isPalindrome(s, 0, j)) {
                    cut[i] = Math.min(cut[i], cut[j] + 1);
                }
            }
        }
        
        return cut[s.length()] - 1;
    }
    
    private boolean isPalindrome(String s, int start, int end){ // check if substring i,j of s is palindrome
        
    }
    
}