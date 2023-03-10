//LEETCODE : 2
/*
Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry=0;

       
        ListNode dum=new ListNode(-1);
        ListNode ans = dum;
       

       
        while(l1!=null || l2!=null || carry==1){
            int sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            //sum=sum+carry
            sum=sum+carry;
           
            
            //carry=sum/10;
            carry=sum/10;

            //listnode
            //digit=sum%10
           
            
            ans.next=new ListNode(sum%10);    
            ans=ans.next;
        }
        
       
        return dum.next;
    }
}