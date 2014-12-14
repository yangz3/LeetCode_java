public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        
        // heigh and width are the same
        int[][] states = new int[n][n];
        
        for (int i = 0; i < n; i++){
            states[n-1][i] = triangle.get(n-1).get(i);
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                states[i][j] = triangle.get(i).get(j) + Math.min(states[i+1][j], states[i+1][j+1]);
                // wrong: states[i][j] = states[i][j] + Math.min(states[i+1][j], states[i+1][j+1]);
                // wrong: states[i][j] = Math.min(states[i+1][j], states[i+1][j+1]);
            }
        }
        
        return states[0][0];
        
    }
    
}