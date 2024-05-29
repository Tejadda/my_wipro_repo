class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class BalancedBinaryTree {
    
    // Method to check if the binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    
    // Helper method to check the height of the tree
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; // Base case: The height of an empty tree is 0
        }
        
        // Recursively check the height of the left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is not balanced
        }
        
        // Recursively check the height of the right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is not balanced
        }
        
        // Check if the current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }
        
        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // Main method to test the function
    public static void main(String[] args) {
        BalancedBinaryTree treeChecker = new BalancedBinaryTree();
        
        // Creating a balanced binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        
        System.out.println("Is the binary tree balanced? " + treeChecker.isBalanced(root)); // Expected output: true
        
        // Creating an unbalanced binary tree
        TreeNode unbalancedRoot = new TreeNode(1);
        unbalancedRoot.left = new TreeNode(2);
        unbalancedRoot.left.left = new TreeNode(3);
        unbalancedRoot.left.left.left = new TreeNode(4);
        
        System.out.println("Is the binary tree balanced? " + treeChecker.isBalanced(unbalancedRoot)); // Expected output: false
    }
}
