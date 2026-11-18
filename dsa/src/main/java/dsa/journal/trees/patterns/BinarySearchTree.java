package dsa.journal.trees.patterns;

import java.util.ArrayDeque;
import java.util.Deque;

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
    

    /*
        iterative inorder traversal that stops at the k-th visit
        Time O(h + k)
        Space: O(h)
    */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
       
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) { 
                stack.push(curr); 
                curr = curr.left; 
            } // while
            
            curr = stack.pop();
            
            if (--k == 0) return curr.val;
            
            curr = curr.right;
        } // while
        return -1;
    } // kthSmallest


    /*
        Pattern
            find the node by going left or right
            at the node, either splice it out (zero or one child) 
            or replace its value with the inorder successor (two children) and delete the successor

        Time Complexity
            O(h)

        Space Complexity
            O(h) space for the call stack

        Triggers
            delete a node from a BST
            any BST edit where the structure has to stay valid

        Invariant
            each recursive call returns the root of a valid BST for its subtree with the key removed
    */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;    // 0 or 1 child: replace with the other side
            if (root.right == null) return root.left;
            TreeNode succ = root.right;                  // 2 children: find the inorder successor
            while (succ.left != null) succ = succ.left;  // (smallest value in the right subtree)
            root.val = succ.val;                         // copy it up
            root.right = deleteNode(root.right, succ.val); // then delete it from the right subtree
        } // if
        return root;
    }
} // BinarySearchTree
