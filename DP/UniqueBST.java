public class Solution {
    /*
     The case for 3 elements example
     Count[3] = Count[0]*Count[2]  (1 as root)
     + Count[1]*Count[1]  (2 as root)
     + Count[2]*Count[0]  (3 as root)
     
     */
    public int numTrees(int n) {
        
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                count[i] += count[j] * count[i-1-j];
            }
        }
        return count[n];
    }
    
}