package _8_graph._2_medium

import _8_graph._1_easy.GraphAdjacencyList
import java.util.ArrayDeque

/**
 * _04_TopologicalSortKahnAlgorithm.kt
 * Topological Sort of a Directed Acyclic Graph (DAG) using Kahn's In-Degree BFS Algorithm (LeetCode #207 - Course Schedule).
 *
 * Beginner Explanation:
 * 1. Compute in-degree (number of incoming edges) for all nodes.
 * 2. Enqueue all nodes with `in-degree == 0`.
 * 3. Pop front, add to topological order, and decrement in-degrees of neighbors.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
fun main() {
    val graph = GraphAdjacencyList(vertices = 6)
    graph.addEdge(5, 2, isDirected = true)
    graph.addEdge(5, 0, isDirected = true)
    graph.addEdge(4, 0, isDirected = true)
    graph.addEdge(4, 1, isDirected = true)
    graph.addEdge(2, 3, isDirected = true)
    graph.addEdge(3, 1, isDirected = true)

    println("--- Topological Sort (Kahn's BFS Algorithm) ---")
    val topoOrder = topologicalSortKahn(graph)
    println("Topological Ordering: $topoOrder")
}

fun topologicalSortKahn(graph: GraphAdjacencyList): List<Int> {
    val inDegree = IntArray(graph.vertices)

    // Compute in-degrees
    for (v in 0 until graph.vertices) {
        for (neighbor in graph.adjMap[v] ?: emptyList()) {
            inDegree[neighbor]++
        }
    }

    val queue = ArrayDeque<Int>()
    for (v in 0 until graph.vertices) {
        if (inDegree[v] == 0) {
            queue.addLast(v)
        }
    }

    val topoResult = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()
        topoResult.add(curr)

        for (neighbor in graph.adjMap[curr] ?: emptyList()) {
            inDegree[neighbor]--
            if (inDegree[neighbor] == 0) {
                queue.addLast(neighbor)
            }
        }
    }

    return if (topoResult.size == graph.vertices) topoResult else emptyList() // Empty if cycle exists!
}
