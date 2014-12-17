public class Solution {
    public int maxSubArray(int[] A) {
        int sum = Integer.MIN_VALUE;
        if(A == null || A.length == 0){
            return sum;
        }
        
        // states[i] means the maximum sum of the subarray ends with A[i]
        int[] states = new int[A.length + 1];
        states[0] = 0;
        for(int i = 1; i <= A.length; i++){
            states[i] = states[i - 1] + A[i - 1];
            sum = Math.max(sum, states[i]);
            if(states[i] < 0){ // previous subarray has no positive contribution to the following subarray
                states[i] = 0;
            }
        }
        
        return sum;
        
    }
    
}