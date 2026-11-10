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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int size = 0;
        q.add(root);
        q.add(null);
        ans.add((double)root.val);
        double sum = 0;
        while(!q.isEmpty()){
           TreeNode curr = q.remove();
           if(curr == null){
            if(q.isEmpty()){
                break;
            }else{
                double avg = sum/size;
                ans.add(avg);
                sum = 0;
                size = 0;
                q.add(null);
            }
           }else{
            
            if(curr.left != null){
                q.add(curr.left);
                sum += curr.left.val;
                size++;
            }
            if(curr.right != null){
                q.add(curr.right);
                sum += curr.right.val;
                size++;
            }
           }
        }
        return ans;
    }
}