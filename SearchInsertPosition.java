public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0){
            return 0;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target){
                return mid;
            }
            if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        // order matters
        
        if(A[start] == target){
            return start;
        }
        
        if(A[end] == target){
            return end;
        }
        
        if(A[end] < target){
            return end + 1;
        }
        
        if(A[start] < target){
            return start + 1;
        }
        
        return start;
        
    }
}