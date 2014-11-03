public class Solution {
    public boolean canJump(int[] A) {
        
        int furthestReach = 0;
        for(int i = 0; i < A.length; i++){
            if(furthestReach >= i){
                int canReach = i+A[i];
                furthestReach = Math.max(canReach, furthestReach);
            }
        }
        
        return furthestReach >= A.length -1;
        
    }
    
}