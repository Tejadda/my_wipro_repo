import java.util.*;

public class DijkstraAlgorithm {

    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        
        // Initialize distances with infinity for all nodes except the start node
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        
        priorityQueue.add(new Node(start, 0));
        
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            String current = currentNode.name;
            int currentDistance = currentNode.distance;
            
            // Check if the current distance is greater than the known distance
            // If so, skip it
            if (currentDistance > distances.get(current)) {
                continue;
            }
            
            // Iterate over the neighbors of the current node
            for (Map.Entry<String, Integer> neighbor : graph.get(current).entrySet()) {
                String next = neighbor.getKey();
                int weight = neighbor.getValue();
                int distance = currentDistance + weight;
                
                // If this path to the neighbor is shorter than any previous one,
                // update the distance and add it to the priority queue
                if (distance < distances.get(next)) {
                    distances.put(next, distance);
                    priorityQueue.add(new Node(next, distance));
                }
            }
        }
        
        return distances;
    }

    static class Node {
        String name;
        int distance;
        
        Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<>());
        graph.put("B", new HashMap<>());
        graph.put("C", new HashMap<>());
        graph.put("D", new HashMap<>());

        // Add edges and their weights
        graph.get("A").put("B", 1);
        graph.get("A").put("C", 4);
        graph.get("B").put("A", 1);
        graph.get("B").put("C", 2);
        graph.get("B").put("D", 5);
        graph.get("C").put("A", 4);
        graph.get("C").put("B", 2);
        graph.get("C").put("D", 1);
        graph.get("D").put("B", 5);
        graph.get("D").put("C", 1);

        String startNode = "A";
        Map<String, Integer> shortestDistances = dijkstra(graph, startNode);

        System.out.println("Shortest distances from node " + startNode + ":");
        for (Map.Entry<String, Integer> entry : shortestDistances.entrySet()) {
            System.out.println("To node " + entry.getKey() + ": Distance = " + entry.getValue());
        }
    }
}
