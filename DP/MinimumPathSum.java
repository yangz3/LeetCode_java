public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length == 0){
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] states = new int[m][n];
        states[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            states[i][0] = grid[i][0] + states[i-1][0];
        }
        for(int j = 1; j < n; j++){
            states[0][j] = grid[0][j] + states[0][j-1];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                states[i][j] = Math.min(states[i-1][j], states[i][j-1]) + grid[i][j];
            }
        }
        
        return states[m-1][n-1];
    }
    
}