public class LongestCommonSubstring {
    
    //这道题用dp的意义不大，也可以用两重循环brutal force
    //但是LCSubsequence由于a.charAt(i - 1) ！= b.charAt(j - 1)时要保留之前subproblem的结果，因此dp价值提现
    
    // states[i][j]代表以stringA[i]和stringB[j]结尾的字符串当前最大连续相同字符串的长度是多少
    
    // The idea is to find length of the longest common suffix for all
    // substrings of both strings and store these lengths in a table.
    private static int LCSubString(String a, String b) {
        int ret = 0;
        int[][] LCSStates = new int[a.length() + 1][b.length() + 1];
        
        // init states
        LCSStates[0][0] = 0;
        
        for (int i = 1; i < a.length(); i++) {
            LCSStates[i][0] = 0;
        }
        
        for (int j = 1; j < b.length(); j++) {
            LCSStates[0][j] = 0;
        }
        
        // following steps build LCSStates[][] in from top left to bottom right
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    LCSStates[i][j] = LCSStates[i - 1][j - 1] + 1;
                    ret = Math.max(ret, LCSStates[i][j]); // because difference will clear the builted up value
                } else { // zero difference tolerance 
                    LCSStates[i][j] = 0;
                }
            }
        }
        
        // print out the states matrix
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                System.out.print(LCSStates[i][j]);
            }
            System.out.println("");
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
        String a = "GeeksforGeeks";
        String b = "GeeksQuiz";
        System.out.println(LCSubString(a, b));
        
    }
    
}
