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
//     public int kthSmallest(TreeNode root, int k) {
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode curr = root;

//         while (curr != null || !stack.isEmpty()) {
//             // Go left as far as possible
//             while (curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             }

//             // Process node
//             curr = stack.pop();
//             k--;
//             if (k == 0) return curr.val;

//             // Move to right subtree
//             curr = curr.right;
//         }
//         return -1; // should never reach here if k is valid
//     }
// }
class Solution {
    int count = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna