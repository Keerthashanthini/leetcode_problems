class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][]board){
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(Possible(board,k,i,j)){
                            board[i][j]=k;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean Possible(char board[][],char ch,int r,int c){
        //row check
        for(int j=0;j<9;j++){
            if(board[r][j]==ch){
                return false;
            }
        }
        //column check
        for(int i=0;i<9;i++){
            if(board[i][c]==ch){
                return false;
            }
        }
        //to get new row and col
        int block_row=r/3*3;
        int block_col=c/3*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[block_row+i][block_col+j]==ch){
                    return false;
                }
            }
        }
        return true;

    }
}
