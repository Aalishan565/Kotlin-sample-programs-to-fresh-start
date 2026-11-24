package _8_graph._1_easy

/**
 * _03_DepthFirstSearchDFS.kt
 * Graph Depth-First Search (DFS) Traversal using Recursion.
 *
 * Beginner Explanation:
 * Explores as far as possible along each branch before backtracking.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V) for recursion stack and visited array
 */
fun main() {
    println("--- Depth-First Search (DFS) ---")
    val graph = GraphAdjacencyList(vertices = 5)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 4)

    print("DFS Traversal starting from vertex 0: ")
    dfsTraversal(graph, startVertex = 0)
    println()
}

fun dfsTraversal(graph: GraphAdjacencyList, startVertex: Int) {
    val visited = BooleanArray(graph.vertices)

    fun dfs(vertex: Int) {
        visited[vertex] = true
        print("$vertex ")

        for (neighbor in graph.adjMap[vertex] ?: emptyList()) {
            if (!visited[neighbor]) {
                dfs(neighbor)
            }
        }
    }

    dfs(startVertex)
}
