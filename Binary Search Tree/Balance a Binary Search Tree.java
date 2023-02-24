//LEETCODE 1382

/*Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.*/

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
//TC:O(N)  SC:O(N)
class Solution {
    //convet into bst
    void TreetoList(List<Integer>list, TreeNode node){
        if(node==null){
            return;
        }
        //inorder traversal
        TreetoList(list, node.left);
        list.add(node.val);
        TreetoList(list, node.right);
    }

    TreeNode BuildBST(int st, int en, List<Integer>list ){
        if(st>en){
            return null;
        }
        //construct BST 
        int mid=(st+en)/2;
       TreeNode node=new TreeNode(list.get(mid));

        node.left=BuildBST(st, mid-1, list);
        node.right=BuildBST(mid+1, en, list);

        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>list=new  ArrayList<>();

        TreetoList(list, root);

        return BuildBST(0, list.size()-1, list);
    }
}
