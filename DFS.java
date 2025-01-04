class Solution {
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer>ans=new ArrayList<>();
        int[]visited=new int[graph.size()];
        dfs(graph,0,ans,visited);
        return ans;
    }
    void dfs(ArrayList<ArrayList<Integer>>graph,int src,ArrayList<Integer>ans,int[]visited){
        ans.add(src);
        visited[src]=1;
        ArrayList<Integer>al=graph.get(src);
        for(int i:al){
            if(visited[i]==0)dfs(graph,i,ans,visited);
        }
    }
}
