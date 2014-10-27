public class Solution {
    public int[] searchRange(int[] A, int target) {
        // search twice: one for head, one for tail
        int head = searchForHead(A, target);
        int tail = searchForTail(A, target);
        int[] ret = {head, tail};
        return ret;
    }
    
    private int searchForHead(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        int head = -1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target){
                head = mid;
                end = mid;
            }else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(A[start] == target){ // easy to forget start end are just index
            return start; // return, not head = start because we want start's priority higher than end
        }
        if(A[end] == target){
            return end;
        }
        return head;
    }
    
    private int searchForTail(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        int tail = -1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target){
                tail = mid;
                // not break and return, keep searching
                start = mid;
            }else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(A[end] == target){
            return end;
        }
        
        if(A[start] == target){
            return start;
        }
        
        return tail;
    }
    
    
}