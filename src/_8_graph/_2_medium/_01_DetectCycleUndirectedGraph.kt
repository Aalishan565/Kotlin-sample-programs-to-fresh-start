package _8_graph._2_medium

import _8_graph._1_easy.GraphAdjacencyList

/**
 * _01_DetectCycleUndirectedGraph.kt
 * Detects if a cycle exists in an Undirected Graph using DFS with parent tracking.
 *
 * Beginner Explanation:
 * If a visited neighbor is NOT the parent of the current node, a cycle exists!
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
fun main() {
    val cyclicGraph = GraphAdjacencyList(4)
    cyclicGraph.addEdge(0, 1)
    cyclicGraph.addEdge(1, 2)
    cyclicGraph.addEdge(2, 3)
    cyclicGraph.addEdge(3, 0) // Cycle

    println("--- Detect Cycle in Undirected Graph ---")
    println("Does cyclicGraph have a cycle? ${hasCycleUndirected(cyclicGraph)}")
}

fun hasCycleUndirected(graph: GraphAdjacencyList): Boolean {
    val visited = BooleanArray(graph.vertices)

    fun dfsCycle(node: Int, parent: Int): Boolean {
        visited[node] = true

        for (neighbor in graph.adjMap[node] ?: emptyList()) {
            if (!visited[neighbor]) {
                if (dfsCycle(neighbor, node)) return true
            } else if (neighbor != parent) {
                return true // Visited neighbor that is not parent -> Cycle!
            }
        }
        return false
    }

    for (v in 0 until graph.vertices) {
        if (!visited[v]) {
            if (dfsCycle(v, -1)) return true
        }
    }

    return false
}
