class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[]vis=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(isConnected,i,vis);
                ans++;
            }
        }
        return ans;
    }
    void dfs(int[][]isConnected,int src,int vis[]){
        vis[src]=1;
        for(int j=0;j<isConnected[0].length;j++){
            if(isConnected[src][j]==1 & vis[j]==0){
                dfs(isConnected,j,vis);
            }
        }
    }
}
