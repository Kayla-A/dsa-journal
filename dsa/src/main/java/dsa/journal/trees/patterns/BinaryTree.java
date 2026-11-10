package dsa.journal.trees.patterns;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    /*
        Pattern
            solve the problem for the left and right subtrees, then combine those answers with the current node

        Time Complexity
            O(n) every node is visited once

        Space Complexity
            O(h) for the call stack: O(log n) for a balanced tree and O(n) for a chain

        Triggers
            binary tree
            depth
            height
            same
            subtree
            path
            any answer that can be built from the left and right subtree answers

        Invariant
            each call returns the correct answer for the subtree rooted at its argument
    */
    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;                 // base case: an empty tree has depth 0
        
        int left = maxDepth(root.left);             // answer for the left subtree
        int right = maxDepth(root.right);           // answer for the right subtree
        
        return 1 + Math.max(left, right);           // combine them with this node
    } // maxDepth


    /*
        Pattern
            keep a queue of nodes waiting to be visited
            each pass, process exactly the nodes that are currently in the queue, which is one full level
            add their children for the next pass

        Time Complexity
            O(n) every node enters and leaves the queue once

        Space Complexity
            O(w) where w is the widest level (up to about n/2 for a full tree)

        Triggers
            level order
            by level
            layer
            nearest
            shortest path in steps
            minimum number of moves
            closest

        Invariant
            at the start of each outer loop, the queue holds exactly the nodes of one level, in left-to-right order
    */
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();                  // snapshot: how many nodes are on this level
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            } // for

            result.add(level);

        } // while
        return result;
    } // levelorder


    /*
        Pattern


        Time Complexity
            O()

        Space Complexity
            O()

        Triggers
            

        Invariant

    */
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
       
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
       
        root.left = right;
        root.right = left;

        return root;
    } // invertTree


    /*
        Pattern
            compute a value for each subtree (the height) and return it
            but at every node also check a “path through this node” candidate against a shared best

        Time Complexity
            O(n)

        Space Complexity
            O(h) space for the call stack

        Triggers
            diameter
            longest path
            the best path through a node
            maximum path sum
            the path may not pass through the root, and the number you return up is different from the number you record

        Invariant
            height(node) returns the height of its subtree, and best is the maximum left + right seen over every node visited so far
    */
    private int best = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return best;
    } // diameterOfBinaryTree

    private int height(TreeNode node) {
        if (node == null) return 0;
       
        int left = height(node.left);
        int right = height(node.right);
        best = Math.max(best, left + right);     // longest path THROUGH this node
        
        return 1 + Math.max(left, right);        // height passed UP to the parent
    } // height


    /*
        Pattern


        Time Complexity
            O()

        Space Complexity
            O()

        Triggers
            

        Invariant

    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;     // both empty: same
        if (p == null || q == null) return false;    // only one empty: different
        
        if (p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    } // isSameTree


} // BinaryTree
