public class Solution {
    public int[] searchRange(int[] A, int target) {
        int startIndex = 0;
        int endIndex = A.length - 1;
        int midIndex = 0;
        int[] ret = new int[2];
        while(startIndex + 1 < endIndex){
            midIndex = startIndex + (endIndex - startIndex)/2;
            if(A[midIndex] >= target){
                endIndex = midIndex ;
            }else{
                startIndex = midIndex ;// rather than midIndex + 1
            }
        }
        if(A[startIndex] == target){
            ret[0] = startIndex;
        }
        else if(A[endIndex] == target){
            ret[0] = endIndex;
        }else{
            ret[0] = -1;
        }
        
        startIndex = 0;
        endIndex = A.length - 1;
        while(startIndex + 1 < endIndex){
            midIndex = startIndex + (endIndex - startIndex)/2;
            if(A[midIndex] <= target){
                startIndex = midIndex ;
            }else{
                endIndex = midIndex ;
            }
        }
        if(A[endIndex] == target){
            ret[1] = endIndex;
        }
        else if(A[startIndex] == target){
            ret[1] = startIndex;
        }else{ // if target is found, it has to be A[startIndex] or A[endIndex]
            ret[1] = -1;
        }
        
        return ret;
        
    }
    
}