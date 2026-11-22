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

    int maxSum = 0;

    class NodeInfo {
        boolean isBST;
        long min;
        long max;
        int sum;

        NodeInfo(boolean isBST, long min, long max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private NodeInfo dfs(TreeNode root) {

        // Empty node is a valid BST
        if (root == null) {
            return new NodeInfo(true, Long.MAX_VALUE,
                                Long.MIN_VALUE, 0);
        }

        NodeInfo left = dfs(root.left);
        NodeInfo right = dfs(root.right);

        // Check BST condition
        if (left.isBST && right.isBST &&
            left.max < root.val &&
            root.val < right.min) {

            int sum = left.sum + right.sum + root.val;

            maxSum = Math.max(maxSum, sum);

            return new NodeInfo(
                true,
                Math.min(root.val, left.min),
                Math.max(root.val, right.max),
                sum
            );
        }

        // Invalid BST
        return new NodeInfo(false, 0, 0, 0);
    }
}