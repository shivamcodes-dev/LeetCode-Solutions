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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> array = new ArrayList<>();
        findArray(root, array);
        int i=0, j=array.size()-1;
        while(i < j){
            int curr = array.get(i) + array.get(j);
            if(curr == k){
                return true;
            }else if(curr > k){
                j--;
            }else{
                i++;
            }
            
        }
        return false;
    }
    public void findArray(TreeNode root, ArrayList<Integer> array) {
        if(root == null){
            return;
        }
        findArray(root.left, array);
        array.add(root.val);
        findArray(root.right, array);
    }
}