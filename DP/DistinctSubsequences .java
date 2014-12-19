public class Solution {
    // relation between problem and subproblem is not obvious. Look up http://blog.csdn.net/abcbc/article/details/8978146
    
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }
        
        int m = S.length();
        int n = T.length();
        
        // Let states(i, j) stand for the number of subsequences of S(0, i) in T(0, j)
        int[][] states = new int[m + 1][n + 1];
        
        states[0][0] = 0;
        
        for (int i = 0; i < m; i++) {
            states[i][0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            states[0][i] = 0;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    states[i][j] = states[i - 1][j] + states[i - 1][j - 1];
                }else{
                    states[i][j] = states[i - 1][j];
                }
            }
        }
        return states[S.length()][T.length()];
    }
    
}