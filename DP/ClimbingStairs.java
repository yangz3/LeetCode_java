public class Solution {
    public int climbStairs(int n) {
        // in this problem, exception check is important
        if(n == 0 || n == 1){
            return n;
        }
        
        int[] states = new int[n + 1];
        
        states[0] = 0;
        states[1] = 1;
        states[2] = 2;
        for(int i = 3; i <= n; i++){
            states[i] = states[i - 1] + states[i - 2];
        }
        return states[n];
    }
    
}