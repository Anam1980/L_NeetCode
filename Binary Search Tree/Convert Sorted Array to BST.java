//LEETCODE 108

/*Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.*/

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
class Solution {
    public TreeNode BuildTree(int st, int en, int[]arr){
        if(st>en)return null;
        //L P R

        int mid=(st+en)/2;

        TreeNode node=new TreeNode(arr[mid]);

        node.left=BuildTree(st, mid-1, arr);
        node.right=BuildTree(mid+1, en, arr);

        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
       return BuildTree(0, nums.length-1, nums);
    }
}

 
