class Solution {
    class Node{
        HashMap<Character,Node>child;
        boolean isEnd;
        public Node(){
            child=new HashMap<>();
            isEnd=false;
        }
    }
    private Node root;
    public List<String> findWords(char[][] board, String[] words) {
        root=new Node();
        for(String s:words){
            insert(s);
        }
        int n=board.length;
        int m=board[0].length;
        HashSet<String>ans=new HashSet<>();
        //traversing
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=board[i][j];
                //if the node is present in the root,we have call to the dfs and also call the 4 recursive calls,to find the word. 
                if(root.child.containsKey(ch)){
                    //it prevents from going back to 'o',when it is in 'a'
                    boolean[][]vis=new boolean[n][m];
                    dfs(board, i, j, ans,"",vis,root); 
                }
            }
        }
        return new ArrayList<>(ans);
    }
    void dfs(char[][]board,int r,int c,HashSet<String>ans,String ans_so_far,boolean[][]vis,Node node){
        int n=board.length;
        int m=board[0].length;
        //base condition
        if(r<0 || r>=n || c<0 || c>=m || vis[r][c]){
            return;
        }
        char ch=board[r][c];
        if(!node.child.containsKey(ch)){
            return;
        }
        vis[r][c]=true;
        node=node.child.get(ch);
        ans_so_far+=ch;
        //if the current node marks the end of a word,add it to the result set
        if(node.isEnd==true){
            ans.add(ans_so_far);
        }
        //explore neighbors
        dfs(board,r-1,c,ans,ans_so_far,vis,node);//up
        dfs(board,r+1,c,ans,ans_so_far,vis,node);//right
        dfs(board,r,c-1,ans,ans_so_far,vis,node);//down
        dfs(board,r,c+1,ans,ans_so_far,vis,node);//left
        //backtracking
        vis[r][c]=false;
    }
    void insert(String word){
        Node temp=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(temp.child.containsKey(ch)){
                temp=temp.child.get(ch);
            }
            else{
                Node nn=new Node();
                temp.child.put(ch,nn);
                temp=nn;
            }
        }
        temp.isEnd=true;
       
    }
}
