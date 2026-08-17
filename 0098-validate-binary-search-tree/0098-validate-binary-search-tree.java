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
 
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }

//     private boolean helper(TreeNode node, long min, long max) {
//         if (node == null) return true;
//         if (node.val <= min || node.val >= max) return false;
//         return helper(node.left, min, node.val) && helper(node.right, node.val, max);
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        long prev = Long.MIN_VALUE;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val <= prev) return false;
            prev = curr.val;
            curr = curr.right;
        }
        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna