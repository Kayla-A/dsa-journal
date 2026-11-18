package dsa.journal.trees.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import dsa.journal.trees.patterns.TreeNode;

public class BST {
    // recursive
    // ignores duplicates
    public static void insert(TreeNode root, int val) {
        if(root == null) return;
        if(root.val == val) return;
        
        if(root.val > val && root.left == null) root.left = new TreeNode(val); 
        else if(root.val > val) insert(root.left, val);
        else if(root.val < val && root.right == null) root.right = new TreeNode(val); 
        else insert(root.left, val);
        
        return;
    } // insert

    public static boolean contains(TreeNode root, int val) {
        while(root != null) {
            if(root.val == val) return true;
            else if(root.val > val) root = root.left;
            else root = root.right;
        } // while

        return false;
    } // contains

    // throw on empty tree
    public static int min(TreeNode root) throws IllegalArgumentException {
        if(root == null) throw new IllegalArgumentException();
        
        TreeNode curr = root;

        while(curr.left != null) {
            curr = curr.left;
        }

        return curr.val;
    } // min

    // throw on empty tree
    public static int max(TreeNode root) throws IllegalArgumentException {
        if(root == null) throw new IllegalArgumentException();
        
        TreeNode curr = root;

        while(curr.right != null) {
            curr = curr.right;
        }

        return curr.val;
    } // max

    // returns sorted List<Integer>
    public static List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list);
        return list;

    } // inorder
    
    private static void dfs(TreeNode root, List<Integer> list) {
        if(root == null) return;

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    } // dfs

    static int height = 0;
    public static int height(TreeNode root) {
        return dfs(root, 0,0);
    } // height

    private static int dfs(TreeNode root, int depth, int max) {
        if(root == null) return depth;
        depth += 1;
        max = Math.max(dfs(root.left, depth, max), dfs(root.right, depth, max));
        return max;
    } // dfs
    
    public static int size(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        int res = 0;
        q.add(root);

        while(!q.isEmpty()) {
            res += q.size();
            for(int i = q.size(); i > 0; i--) {
                TreeNode top = q.remove();
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            } // for
        } // while

        return res;
    } // size

    public static boolean delete(TreeNode root, int val) {
        return false;
    } // delete

} // BST
