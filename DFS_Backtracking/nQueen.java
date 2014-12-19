public class Solution {
    public List<String[]> solveNQueens(int n) {
        
        ArrayList<String[]> result = new ArrayList<String[]>();
        if (n <= 0) {
            return result;
        }
        search(n, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void search(int n, ArrayList<Integer> cols, ArrayList<String[]> result) {
        // similar to DFS, need to pass candidates and final result set to recursion funciton
        if (cols.size() == n) {
            result.add(drawChessboard(cols));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (!isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            search(n, cols, result); // backtracking algorithm character: call recursion funcion in loop
            cols.remove(cols.size() - 1); // need to retrieve candidates
        }
    }
    
    private boolean valid(){// check if current col does not have any conflit with other queens
        
    }
    
    private String[] drawChessboard(){ //draw chess board by cols array
        
    }
    
}