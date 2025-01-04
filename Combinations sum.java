class Solution {
    List<Integer>temp=new ArrayList<>();
    List<List<Integer>>res=new ArrayList<>();
    public void Backtrack(int curr_sum,int target,int start_index,int[] numbers){
        if(curr_sum==target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(curr_sum>target){
            return;
        }
        for(int i=start_index;i<numbers.length;i++){
            temp.add(numbers[i]);
            Backtrack(curr_sum+numbers[i],target,i,numbers);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] numbers, int target){
        Backtrack(0,target,0,numbers);
        return res;
        // Write your code here
        
    } 
}
