//LEETCODE 109

/*Convert Sorted List to Binary Search Tree

Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
height-balanced
binary search tree.
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//TC:O(N) SC:O(1)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        if(head==null)return null;

        if(head.next==null)return new TreeNode(head.val);
        
        //variable for find the median 
        ListNode slow=head;
        ListNode fast=head;
        //prev is for left of the midi.e.prev of slow(mid)
        ListNode prev=null;

        //go at middle node of linkedlist
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        //create node
        TreeNode root = new TreeNode(slow.val);

        //make next of prev null for left part
        if (prev != null) {
            prev.next = null;
            root.left = sortedListToBST(head);
        }
        //right part is right of mid
        if(slow.next!=null)
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
