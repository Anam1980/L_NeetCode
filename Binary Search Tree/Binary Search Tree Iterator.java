//LEETCODE 173

/* Binary Search Tree Iterator

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.*/

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
class BSTIterator {

//create Stack to store node Left Print Right
    Stack<TreeNode>bst=new Stack<>();
    public BSTIterator(TreeNode root) {
        //first add all left
        while(root!=null){
            bst.push(root);
            root=root.left;//going left same as recursion upto null
        }
    }
    
    public int next() {
        //when we are end traversing left then now print 
        TreeNode curr=bst.peek();
        bst.pop();
        //now traverse right after print

        TreeNode rnode=curr.right;
        while(rnode!=null){
            bst.push(rnode);
            rnode=rnode.left;//after going to right again we are at left first so restart process, 
            //same as recursion, again function   call left
        }

        return curr.val;
    }
    
    public boolean hasNext() {
        //check elment is present or not
        if(bst.size()>0)return true;

        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
