class WordDictionary {
    class Node{
        HashMap<Character,Node>children;
        boolean isEnd;
        public Node(){
            children=new HashMap<>();
            isEnd=false;
        }
    }
    private Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node temp=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(temp.children.containsKey(ch)){
                temp=temp.children.get(ch);
            }
            else{
                Node nn=new Node();
                temp.children.put(ch,nn);
                temp=nn;
            }
        }
        temp.isEnd=true;
        
    }
    public boolean search(String word) {
        return isAvailable(word,0,root);
    }
    boolean isAvailable(String word,int indx,Node root){
        if (indx == word.length()) {
            return root.isEnd;
        }
        
        char ch = word.charAt(indx);
        
        if (ch != '.') {
            if (root.children.containsKey(ch)) {
                return isAvailable(word, indx + 1, root.children.get(ch));
            } else {
                return false;
            }
        } else {
            for (Node child : root.children.values()) {
                if (isAvailable(word, indx + 1, child)) {
                    return true;
                }
            }
            return false; 
        }
    }

}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
