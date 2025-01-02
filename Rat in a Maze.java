class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String>ans=new ArrayList<>();
        allPath(ans,"",mat,0,0);
        Collections.sort(ans);
        return ans;   
    }
    void allPath(ArrayList<String>ans,String ans_so_far,ArrayList<ArrayList<Integer>>mat,int row,int col){
        int n=mat.size();
        int m=mat.get(0).size();
        if(row>=n || col>=m || row<0 || col<0 || mat.get(row).get(col)==0){
            return;
        }
        if(row==n-1 && col==m-1){
            ans.add(ans_so_far);
            return;
        }
        mat.get(row).set(col,0);
        allPath(ans,ans_so_far+"U",mat,row-1,col);//up
        allPath(ans,ans_so_far+"R",mat,row,col+1);//right
        allPath(ans,ans_so_far+"D",mat,row+1,col);//down
        allPath(ans,ans_so_far+"L",mat,row,col-1);//left
        mat.get(row).set(col,1);//backtracking
        
    }
}
