class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String>hs=new HashSet<>();
        String[]pattern={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String s:words){
            StringBuilder sb=new StringBuilder();
            for(char c:s.toCharArray()){
                sb.append(pattern[c-'a']);
            }
            hs.add(sb.toString());
        }
        return hs.size();
        
    }
}
