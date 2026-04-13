class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    // Helper function to compute depth
    private int depth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // Update diameter at this node
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Return height of subtree
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
