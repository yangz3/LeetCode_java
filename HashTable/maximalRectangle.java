public class Solution {
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null ||matrix.length==0){
            return 0;
        }
        
        int[][] heights=new int[matrix.length][matrix[0].length];
        
        // build heights table, once we have heights table, at each row, we can use
        // method which used in question of Largest Rectangle in Histogram to calculate
        // max area at until this row,.
        for(int i=0; i < heights.length; i++){
            Arrays.fill(heights[i], 0);
        }
        
        for (int row=0; row<matrix.length; row++){
            for (int col=0; col<matrix[0].length; col++){
                if (row==0){
                    heights[row][col]= matrix[row][col] - '0';
                }
                else{
                    heights[row][col]= matrix[row][col] == '0'? 0:heights[row-1][col] + (matrix[row][col] - '0');
                }
            }
        }
        
        int max=0;
        
        for (int row=0; row<heights.length; row++){
            max=Math.max(max, maxArea(heights[row]));
        }
        
        return max;
    }
    
    // calculate maxArea for each row
    private int maxArea(int[] height){
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
        
    }
    
}