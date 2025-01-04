class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> graph) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        Queue<Integer>q=new ArrayDeque<>();
        int visited[]=new int[V];
        q.add(0);
        while(q.size()>0){
            //rwa
            //remove
            int rem=q.remove();
            //work
            if(visited[rem]==0)ans.add(rem);
            visited[rem]=1;
            //add
            ArrayList<Integer>al=graph.get(rem);
            for(int i : al){
                if(visited[i]==0)q.add(i);
            }
        }
        return ans;
        
    }
}
