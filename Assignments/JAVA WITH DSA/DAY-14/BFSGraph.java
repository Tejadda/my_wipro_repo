package com.DAY_14;
import java.util.*;
public class BFSGraph {
    private int numVertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public BFSGraph(int vertices) {
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

    // Method to perform BFS and print the nodes in the order they are visited
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            Iterator<Integer> it = adjList[vertex].listIterator();
            while (it.hasNext()) {
                int adj = it.next();
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    // Main method to test the BFS implementation
    public static void main(String[] args) {
        BFSGraph graph = new BFSGraph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("BFS traversal starting from vertex 0:");
        graph.BFS(0);
    }
}

