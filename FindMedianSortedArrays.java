public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0 ;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        
    }
    
    public int findKth(int A[], int A_start, int B[], int B_start, int k){
        // three base case A_start B_start and k
        if(A_start >= A.length){
            return B[B_start + k - 1];
        }
        if(B_start >= B.length){
            return A[A_start + k - 1];
        }
        
        if(k == 1){
            return Math.min(A[A_start], B[B_start]);
        }
        
        int AMidValue = A_start + k/2 - 1 < A.length ?
        A[A_start + k/2 - 1] : Integer.MAX_VALUE;
        
        int BMidValue = B_start + k/2 - 1 < B.length ?
        B[B_start + k/2 - 1] : Integer.MAX_VALUE;
        
        if (AMidValue < BMidValue){
            return findKth(A, A_start+k/2, B, B_start, k - k/2); // the elements left is k - k/2 rather than k/2
        }else{
            return findKth(A, A_start, B, B_start+k/2, k - k/2);
        }
        
    }
    
}
