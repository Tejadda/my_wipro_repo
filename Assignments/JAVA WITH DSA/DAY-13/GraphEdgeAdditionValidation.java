import java.util.*;

public class GraphEdgeAdditionValidation {
    private Map<Character, List<Character>> graph;

    public GraphEdgeAdditionValidation() {
        graph = new HashMap<>();
    }

    public void addEdge(char u, char v) {
        if (!graph.containsKey(u)) {
            graph.put(u, new ArrayList<>());
        }
        graph.get(u).add(v);
    }

    public boolean hasCycleAfterAddingEdge(char u, char v) {
        // Add the edge
        addEdge(u, v);

        // Check for cycle using DFS
        Set<Character> visited = new HashSet<>();
        Set<Character> currentlyVisiting = new HashSet<>();

        for (char node : graph.keySet()) {
            if (!visited.contains(node) && hasCycleDFS(node, visited, currentlyVisiting)) {
                // Cycle detected
                // Remove the added edge
                graph.get(u).remove(Character.valueOf(v));
                return true;
            }
        }

        // No cycle detected
        return false;
    }

    private boolean hasCycleDFS(char node, Set<Character> visited, Set<Character> currentlyVisiting) {
        visited.add(node);
        currentlyVisiting.add(node);

        for (char neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (hasCycleDFS(neighbor, visited, currentlyVisiting)) {
                    return true;
                }
            } else if (currentlyVisiting.contains(neighbor)) {
                return true; // Cycle detected
            }
        }

        currentlyVisiting.remove(node);
        return false;
    }

    public static void main(String[] args) {
        GraphEdgeAdditionValidation graph = new GraphEdgeAdditionValidation();
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'C');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'A');

        char u = 'C';
        char v = 'A';

        if (graph.hasCycleAfterAddingEdge(u, v)) {
            System.out.println("Edge (" + u + ", " + v + ") not added because it creates a cycle.");
        } else {
            System.out.println("Edge (" + u + ", " + v + ") added successfully.");
        }
    }
}
