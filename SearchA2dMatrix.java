public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int start = 0;
        int end = r * c - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(matrix[mid/c][mid%c] == target){
                return true;
            }
            if(matrix[mid/c][mid%c] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(matrix[start/c][start%c] == target){
            return true;
        }
        
        if(matrix[end/c][end%c] == target){
            return true;
        }
        
        return false;
        
    }
    
}