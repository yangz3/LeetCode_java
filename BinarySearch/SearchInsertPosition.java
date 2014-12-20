public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0){
            return 0;
        }
        
        int startIndex = 0;
        int endIndex = A.length - 1;
        
        while(startIndex + 1 < endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if(A[midIndex] == target){
                return midIndex;
            }else{
                if(A[midIndex] < target){
                    startIndex = midIndex; // rather than midIndex + 1
                }
                if(A[midIndex] > target){
                    endIndex = midIndex;
                }
            }
        }
        
        if(A[endIndex] == target){
            return endIndex;
        }
        if(A[endIndex] < target){
            return endIndex + 1;
        }
        if(A[startIndex] >= target){ //there is a chance where A[startIndex] is still bigger than the target
            return startIndex;
        }
        
        return startIndex + 1;
        
    }
    
}