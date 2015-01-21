/*
 Given a string S and a string T, count the number of distinct subsequences of T in S.
 
 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 
 Here is an example:
 S = "rabbbit", T = "rabbit"
 
 Return 3.
 
*/

 public class Solution {
    // relation between problem and subproblem is not obvious. Look up http://blog.csdn.net/abcbc/article/details/8978146
    
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }
        
        int m = S.length();
        int n = T.length();
        
        // Let states(i, j) stand for the number of subsequences of T(0, j) in S(0, i)
        int[][] states = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            states[i][0] = 1;
        }
        
        for (int j = 1; j < n; j++) {
            states[0][j] = 0;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    states[i][j] = states[i - 1][j] + states[i - 1][j - 1]; // there is no states[i][j-1]
                }else{
                    states[i][j] = states[i - 1][j];
                }
            }
        }
        return states[S.length()][T.length()];
    }
    
}