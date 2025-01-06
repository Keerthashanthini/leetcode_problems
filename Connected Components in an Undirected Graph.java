//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(s[j]);
            }
        }

        return mat;
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (ArrayList<Integer> a : m) {
            for (int e : a) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int e = Integer.parseInt(br.readLine());
            int v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.connectedcomponents(v, edges);
            Collections.sort(res, (a, b) -> Integer.compare(a.get(0), b.get(0)));
            IntMatrix.print(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<ArrayList<Integer>> connectedcomponents(int n, int[][] edges) {
        ArrayList<Integer>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        int vis[]=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                ArrayList<Integer>temp=new ArrayList<>();
                dfs(graph,i,temp,vis);
                Collections.sort(temp);
                ans.add(temp);
            }
        }
        return ans;
    }
    void dfs(ArrayList<Integer>[] graph,int src,ArrayList<Integer>temp,int vis[]){
        temp.add(src);
        vis[src]=1;
        
        for(int i:graph[src]){
            if(vis[i]==0){
                dfs(graph,i,temp,vis);
            }
        }
    }
    
}
