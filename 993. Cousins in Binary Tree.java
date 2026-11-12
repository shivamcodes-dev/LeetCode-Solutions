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
    TreeNode xparant = null;
    TreeNode yparant = null;
    int xLevel = -1;
    int yLevel = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        return findIsCousins(root, null, 0, x, y);
    }
    public boolean findIsCousins(TreeNode root, TreeNode parant, int level,  int x, int y) {
        if(root == null){
            return false;
        }
        if(root.val == x){
            xparant = parant;
            xLevel = level;
        }
        if(root.val == y){
            yparant = parant;
            yLevel = level;
        }
        if(xLevel == yLevel && xparant != yparant){
            return true;
        }
        return findIsCousins(root.left, root, level+1, x, y) || findIsCousins(root.right, root, level+1, x, y);
    }
}