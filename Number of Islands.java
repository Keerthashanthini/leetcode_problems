class Solution {
    public int numIslands(char[][] grid) {
        int c=0;
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    c++;
                }
            }
        }
        return c;
    }
    public void dfs(char[][]grid,int row,int col){
        int m=grid.length;
        int n=grid[0].length;
        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]=='0')return;
        grid[row][col]='0';
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
    }
}
