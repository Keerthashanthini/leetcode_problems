// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int[]arr1=new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i]=sc.nextInt();
        }
        Arrays.sort(arr1);
        int n2=sc.nextInt();
        int[]arr2=new int[n2];
        for(int i=0;i<n2;i++){
            arr2[i]=sc.nextInt();
        }
        Arrays.sort(arr2);
        int[]merged=new int[n1+n2];
        int i=0,j=0,k=0;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                merged[k++]=arr1[i++];
            }
            else{
                merged[k++]=arr2[j++];
            }
        }
        while(i<n1){
            merged[k++]=arr1[i++];
        }
        while(j<n2){
            merged[k++]=arr2[j++];
        }
        for(int x:merged){
            System.out.print(x+" ");
        }
    }
}
