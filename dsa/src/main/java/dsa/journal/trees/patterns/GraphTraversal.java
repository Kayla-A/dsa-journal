package dsa.journal.trees.patterns;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {
    /*
        Pattern
            graph traversal with a visited set
            
        Time Complexity
            O(V + E) for graph 
            O(rows x cols) for grid

        Space Complexity
            O(V) for the visited set plus the recursion stack or queue

        Triggers
            connected
            islands
            regions
            reachable
            path exists
            flood fill
            number of components
            a grid where you move up, down, left, and right

        Invariant
            A node is marked visited when you first reach it, so each node is processed once
    */
    
    // grid neighbors, always bounds-check before reading grid[r][c]
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};


    // build the graph from an edge list (undirected)
    int n = 6; // nodes are 0..n-1
    int[][] edges = {{0,1},{0,2},{1,3},{4,5}};
    boolean[] visited = new boolean[n]; // all false to start
    List<List<Integer>> adj = new ArrayList<>();

    void buildGraph() {
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>()); // one empty list per node
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]); // drop this line for a directed graph
        } // for
    } // buildGraph
    

    // DFS (recursive)
    void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for(int next : adj.get(node)) {
            if (!visited[next]) dfs(next, adj, visited);
        } // for
    } // dfs


    // BFS (queue)
    void bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        visited = new boolean[n];
        q.add(start); 
        visited[start] = true; // mark BEFORE or WHEN adding
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj.get(cur)) {
                if (!visited[next]) { 
                    visited[next] = true; 
                    q.add(next); 
                } // if
            } // for
        } // while
    } // bfs


    // cointing components
    int components = 0;
    void countComponents() {
        for(int i = 0; i< n; i++) {
            if(!visited[i]) {
                components++;
                dfs(i, adj, visited);
            } // if
        } // for
    } // countComponents
    /*
        Pattern
            BFS by levels and multi-source BFS

        Time Complexity
            O(V + E) for graph 
            O(rows x cols) for grid

        Space Complexity
            O(V + E) for graph
            O(rows x cols) for grid

        Triggers
            minimum time/minutes/steps
            shortest path in an unweighted grid or graph
            nearest
            something that spreads outward each step
            several starting points that spread at the same time

        Invariant
            The first time BFS reaches a node is along a path with the fewest edges
            so mark visited when you add it to the queue
    */
    void bsf() {
        Queue<int[]> q1 = new ArrayDeque<>();
        // 1) add ALL sources to the queue first (and mark them visited)
        int steps = 0;
        while (!q1.isEmpty()) {
            int size = q1.size(); // snapshot = this level
            for (int i = 0; i < size; i++) {
                int[] cur = q1.poll();
                for (int[] d : dirs) {
                    int nr = cur[0] + d[0], nc = cur[1] + d[1];
                    // bounds check, skip if visited/blocked
                    // mark visited, q.add(new int[]{nr, nc})
                } // for
            } // for
            steps++; // watch the off-by-one on the last level
        } // while
    } // bfs

} // GraphTraversal
