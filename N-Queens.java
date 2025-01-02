class Solution {
    /*List<List<String>> result = new ArrayList<>();
    boolean[][] temp;

    void Backtrack(int depth, int n) {
        if (depth == n) {
            result.add(constructBoard(n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(depth, i, n)) {
                temp[depth][i] = true;
                Backtrack(depth + 1, n);
                temp[depth][i] = false;
            }
        }
    }
    boolean isSafe(int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (temp[i][col]) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (temp[i][j]) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (temp[i][j]) {
                return false;
            }
        }
        return true;
    }
    List<String> constructBoard(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(temp[i][j] ? "Q" : ".");//backtracking
            }
            board.add(row.toString());
        }
        return board;
    }
    public List<List<String>> solveNQueens(int n) {
        temp = new boolean[n][n];
        Backtrack(0, n);
        return result;
    }*/
    public List<List<String>>solveNQueens(int n){
        List<List<String>>ans=new ArrayList<>();
        char matrix[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]='.';
            }
        }
        
        solve(matrix,0,ans);
        return ans;
    }
    void solve(char mat[][],int r,List<List<String>>ans){
        if(r==mat.length){
            ArrayList<String>al=new ArrayList<>();
            for(int i=0;i<mat.length;i++){
                String s="";
                for(int j=0;j<mat.length;j++){
                    s+=mat[i][j];
                }
                al.add(s);
            }
            ans.add(al);
            return;
        }
        for(int c=0;c<mat.length;c++){
            if(Possible(mat,r,c)){
                mat[r][c]='Q';
                solve(mat,r+1,ans);
                mat[r][c]='.';//backtracking

            }
        }
    }
    boolean Possible(char mat[][],int r,int c){
        int j=c;
        int i=r;
        while(i>=0){
            if(mat[i][j]=='Q'){
                return false;
            }
            i--;
        }
        j=c;
        i=r;
        while(i>=0 && j>=0){
            if(mat[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        j=c;
        i=r;
        while(i>=0 && j<mat.length){
            if(mat[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}

    
