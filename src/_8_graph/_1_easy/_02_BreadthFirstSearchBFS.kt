package _8_graph._1_easy

import java.util.ArrayDeque

/**
 * _02_BreadthFirstSearchBFS.kt
 * Graph Breadth-First Search (BFS) Traversal using a Queue.
 *
 * Beginner Explanation:
 * Explores graph level by level starting from source node.
 * Use a `visited` boolean array to prevent processing the same node multiple times (avoiding infinite loops).
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V) for Queue and visited array
 */
fun main() {
    println("--- Breadth-First Search (BFS) ---")
    val graph = GraphAdjacencyList(vertices = 5)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 4)

    print("BFS Traversal starting from vertex 0: ")
    bfsTraversal(graph, startVertex = 0)
    println()
}

fun bfsTraversal(graph: GraphAdjacencyList, startVertex: Int) {
    val visited = BooleanArray(graph.vertices)
    val queue = ArrayDeque<Int>()

    visited[startVertex] = true
    queue.addLast(startVertex)

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()
        print("$curr ")

        for (neighbor in graph.adjMap[curr] ?: emptyList()) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                queue.addLast(neighbor)
            }
        }
    }
}
