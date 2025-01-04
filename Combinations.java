public class Main {
    static Vector<Integer>temp=new Vector<>();
    static Vector<Vector<Integer>>res=new Vector<Vector<Integer>>();
    static void Backtrack(int from,int to,int k){
        if(k==0){
            res.add(temp);
            for(int i=0;i<temp.size();i++){
                System.out.print(temp.get(i)+" ");
            }
            System.out.println();
            return;
        }
        for(int i=from;i<=to;i++){
            temp.add(i);
            Backtrack(i+1,to,k-1);
            temp.remove(temp.size()-1);
        }
    }
    static Vector<Vector<Integer>> generateCombinations(int total, int select) {
        Backtrack(1,total,select);
        return res;
        // Write code here
        
    }
