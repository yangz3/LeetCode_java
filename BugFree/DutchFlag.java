public class Solution {
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public void sortColors(int[] A) {
        if(A == null || A.length <= 1){
            return ;
        }
        
        int redCursor = 0;
        int blueCursor = A.length - 1;
        
        int currentCursor = 0;
        while(currentCursor <= blueCursor){
            if(A[currentCursor] == 0){
                swap(A, redCursor, currentCursor);
                redCursor++;
                currentCursor++;
            }else if(A[currentCursor] == 1){
                currentCursor++;
            }else{
                swap(A, blueCursor, currentCursor);
                blueCursor--;
                // the value swapped to the currentCursor cannot be guaranteed to be 1,
                // therefore needed to be checked (no currentCursor++)
            }
        }
        
    }
}