
public class Solution {
    
    public int largestRectangleArea(int[] height){
        int max = 0;
        for (int i = 0; i < height.length; i++){
            int lowerBoundary = i;
            int upperBoundary = i;
            
            while(lowerBoundary > 0 ){
                if(height[lowerBoundary - 1] < height[i]){
                    break;
                }
                lowerBoundary--;
            }
            
            while(upperBoundary < height.length - 1 ){
                if(height[upperBoundary + 1] < height[i]){
                    break;
                }
                upperBoundary++;
            }
            
            
            int thisArea = (upperBoundary - lowerBoundary + 1) * height[i];
            max = Math.max(max, thisArea);
        }
        
        return max;
    }
    
    
    // http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
    // Since every bar is pushed and popped only once, the time complexity of this method is O(n).
    /*
     public int largestRectangleArea(int[] height){
     if (height == null || height.length == 0) {
     return 0;
     }
     
     Stack<Integer> stack = new Stack<Integer>();
     int max = 0;
     for (int i = 0; i < height.length; i++) {
     int curt = height[i];
     // maintain the stack at the same time compute the max area
     // the elements in the stack are in ascending order and are composed of
     // local minimums
     while (!stack.isEmpty() && curt <= height[stack.peek()]) {
     int h = height[stack.pop()];
     int w = stack.isEmpty() ? i : i - stack.peek() - 1;
     max = Math.max(max, h * w);
     }
     stack.push(i);
     }
     
     // add a dummy value -1 to the last of height[] to compute all values in the stack which have not been calculated
     int curt = -1;
     while (!stack.isEmpty() && curt <= height[stack.peek()]) {
     int h = height[stack.pop()];
     int w = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
     max = Math.max(max, h * w);
     }
     
     return max;
     }
     */
}