package com.DAY_14;
import java.util.*;

public class DFSGraph {
    private int numVertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public DFSGraph(int vertices) {
        numVertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge between two nodes
    public void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v); // Since the graph is undirected
    }

    // Recursive DFS function
    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> it = adjList[v].listIterator();
        while (it.hasNext()) {
            int adj = it.next();
            if (!visited[adj]) {
                DFSUtil(adj, visited);
            }
        }
    }

    // Method to perform DFS and print the nodes
    public void DFS() {
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; ++i) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    // Main method to test the DFS implementation
    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("DFS traversal:");
        graph.DFS();
    }
}
