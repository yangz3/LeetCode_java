public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // Tricks to treat it as a 1-D array
            int digit = matrix[mid / cols][mid % cols];
            if (target == digit) {
                return true;
            } else if (target > digit) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}