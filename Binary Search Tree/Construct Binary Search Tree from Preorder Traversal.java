//LEETCODE 1008

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
//TC:O(N) SC:O(H)
class Solution {

    int idx=0;
    TreeNode ListToTree(int[]pre, int n, int lb, int ub){
        //if limit not satistisfies so means null there
        if(idx>=n || pre[idx]>ub || pre[idx]<lb)return null;

        //creaet node , move indexto right
        TreeNode root= new TreeNode(pre[idx++]);

        //go left
        root.left=ListToTree(pre, n, lb, root.val);
        //go right
        root.right=ListToTree(pre, n, root.val, ub);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        //as it is bst we have to build acc. rule of BST so take lower bound and upper bound i.e.limits
        return ListToTree(preorder, preorder.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
