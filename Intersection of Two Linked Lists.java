/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int size(ListNode head){
        int c=0;
        while(head!=null){
            head=head.next;
            c++;
        }
        return c;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int s1=size(headA);
        int s2=size(headB);
        if(s1>s2){
            while(s1>s2){
                s1--;
                headA=headA.next;
            }
        }
        if(s2>s1){
            while(s2>s1){
                s2--;
                headB=headB.next;
            }
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
