public class Solution {
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int mid;
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                // left half of the array is regularly sorted
                if (A[start] <= target && target <= A[mid]) { // use end points of left half to compare
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // right half of the array is regularly sorted
                if (A[mid] <= target && target <= A[end]) { // use end points of right half to compare
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}