class Solution {
    public int[] diStringMatch(String s) {
        int n=s.length();
        int a=0;
        int b=n;
        int[]arr=new int[n+1];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='I'){
                arr[i]=a++;
            }
            else{
                arr[i]=b--;
            }
        }
        arr[n]=a;
        return arr;
    }
}
