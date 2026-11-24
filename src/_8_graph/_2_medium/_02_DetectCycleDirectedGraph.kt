package _8_graph._2_medium

import _8_graph._1_easy.GraphAdjacencyList

/**
 * _02_DetectCycleDirectedGraph.kt
 * Detects if a cycle exists in a Directed Graph using DFS with Recursion Stack tracking (`inRecursionStack`).
 *
 * Beginner Explanation:
 * If we encounter a visited neighbor that is currently active in the recursion stack, a back-edge exists (Cycle!).
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
fun main() {
    val directedGraph = GraphAdjacencyList(4)
    directedGraph.addEdge(0, 1, isDirected = true)
    directedGraph.addEdge(1, 2, isDirected = true)
    directedGraph.addEdge(2, 0, isDirected = true) // Cycle back to 0

    println("--- Detect Cycle in Directed Graph ---")
    println("Does directedGraph have a cycle? ${hasCycleDirected(directedGraph)}")
}

fun hasCycleDirected(graph: GraphAdjacencyList): Boolean {
    val visited = BooleanArray(graph.vertices)
    val inRecursionStack = BooleanArray(graph.vertices)

    fun dfsCycle(node: Int): Boolean {
        visited[node] = true
        inRecursionStack[node] = true

        for (neighbor in graph.adjMap[node] ?: emptyList()) {
            if (!visited[neighbor]) {
                if (dfsCycle(neighbor)) return true
            } else if (inRecursionStack[neighbor]) {
                return true // Found back-edge to active recursion node -> Cycle!
            }
        }

        inRecursionStack[node] = false
        return false
    }

    for (v in 0 until graph.vertices) {
        if (!visited[v]) {
            if (dfsCycle(v)) return true
        }
    }

    return false
}
