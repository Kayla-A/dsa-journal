package dsa.journal.trees;

public class BinarySearchTree {
    /*
        Pattern

        Time Complexity
            O(h)

        Space Complexity
            O(1)

        Triggers
            

        Invariant
    */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        } // while

        return root;
    } // searchBST

    /*
        Pattern
            every node has to fall strictly between the bounds inherited from its ancestors
            going left tightens the upper bound, and going right tightens the lower bound

        Time Complexity
            O(n)

        Space Complexity
            O(h) space for the call stack

        Triggers
            valid binary search tree
            satisfies the BST property
            any check that has to hold across a whole subtree rather than just a node’s children
            

        Invariant
            when valid(node, low, high) runs, every node on the path from the root has already been checked against the range that applies to node
    */
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    } // isValidBST

    private boolean valid(TreeNode node, long low, long high) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) return false;
        return valid(node.left, low, node.val)       // left subtree must stay below this node
            && valid(node.right, node.val, high);    // right subtree must stay above this node
    } // valid
    
} // BinarySearchTree
