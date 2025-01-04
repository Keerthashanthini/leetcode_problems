public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
        data.add(val);
        heapifyUp(data.size()-1);
      // write your code here
    }

    public int remove() {
        if(data.size()==0){
            System.out.println("Underflow");
            return -1;
        }
        int value_to_return=data.get(0);
        int last_item=data.remove(data.size()-1);
        if(data.size()>0){
            data.set(0,last_item);
            heapifyDown(0);
        }
        return value_to_return;
      // write your code here
    } 

    public int peek() {
        if(data.size()==0){
            System.out.println("Underflow");
            return -1;
        }
        return data.get(0);
      // write your code here
    }

    public int size() {
        return data.size();
      // write your code here
    }
    public void heapifyUp(int index){
        while(index>0){
            int parent_index=(index-1)/2;
            if(data.get(parent_index)>data.get(index)){
                swap(parent_index,index);
                index=parent_index;
            }
            else{
                break;
            }
        }
    }
    public void heapifyDown(int index){
        int left_child=2*index+1;
        int right_child=2*index+2;
        int smallest_index=index;
        if(left_child<data.size() && data.get(left_child)<data.get(smallest_index)){
            smallest_index=left_child;
        }
        if(right_child<data.size() && data.get(right_child)<data.get(smallest_index)){
            smallest_index=right_child;
        }
        if(smallest_index != index){
            swap(smallest_index,index);
            heapifyDown(smallest_index);
        }
    }
    public void swap(int index1,int index2){
        int temp=data.get(index1);
        data.set(index1,data.get(index2));
        data.set(index2,temp);
    }
  }
