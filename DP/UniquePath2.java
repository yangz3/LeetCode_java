public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        int[][] states = new int[n][m];
        for(int i = 0; i < m; i++){
            if(obstacleGrid[0][i] != 1){
                states[0][i] = 1;
            }else{
                break;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(obstacleGrid[i][0] != 1){
                states[i][0] = 1;
            }else{
                break;
            }
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(obstacleGrid[i][j] != 1){
                    states[i][j] = states[i-1][j]+states[i][j-1];
                }else{
                    states[i][j] = 0;
                }
            }
        }
        
        return states[n-1][m-1];
    }
    
}