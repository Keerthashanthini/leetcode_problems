class Solution {
    public List<String> findPermutation(String s) {
        // Code here
        List<String>ans=new ArrayList<>();
        HashSet<String>temp=new HashSet<>();
        getPermutation(s, "",temp);
        for(String ss:temp){
            ans.add(ss);
        }
        Collections.sort(ans);
        return ans;
    }
    void getPermutation(String s,String ans,HashSet<String>temp){
        if(s.length()==0){
            temp.add(ans);
            return;
        }
        for(int i=0;i<s.length();i++){//abc
            char ch=s.charAt(i);
            
            //if we take character(a) here it say our new character will be b and c and vice versa for all character
            String newString=s.substring(0,i)+s.substring(i+1,s.length());
            getPermutation(newString,ans+ch,temp);
        }
    }
}
