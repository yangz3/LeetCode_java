public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        // check rows
        for(int i = 0; i < board.length; i++){
            set.clear();
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.' && set.contains(board[i][j])){
                    return false;
                }else{
                    set.add(board[i][j]);
                }
            }
        }
        // check colomns
        for(int i = 0; i < board.length; i++){
            set.clear();
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != '.' && set.contains(board[j][i])){
                    return false;
                }else{
                    set.add(board[j][i]);
                }
            }
        }
        // check cells
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                set.clear();
                for(int m=0; m<3; m++){
                    for(int n=0; n<3; n++){
                        if(board[3*i+m][3*j+n] != '.' && set.contains(board[3*i+m][3*j+n])){
                            return false;
                        }else{
                            set.add(board[3*i+m][3*j+n]);
                        }
                    }
                }
            }
        }
        return true;
    }
    
}