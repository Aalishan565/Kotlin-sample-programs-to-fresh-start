package _8_graph._3_hard

import java.util.PriorityQueue

/**
 * _03_PrimsMinimumSpanningTree.kt
 * Prim's Algorithm to find Minimum Spanning Tree (MST) weight of a connected weighted graph.
 *
 * Beginner Explanation:
 * Greedy choice: Start at arbitrary vertex 0 and repeatedly add the smallest weight edge connecting an unvisited vertex to the growing MST.
 *
 * Time Complexity: O((V + E) log V)
 * Space Complexity: O(V + E)
 */
fun main() {
    println("--- Prim's Minimum Spanning Tree (MST) ---")
    val graph = WeightedGraph(vertices = 5)
    graph.addEdge(0, 1, 2)
    graph.addEdge(0, 3, 6)
    graph.addEdge(1, 2, 3)
    graph.addEdge(1, 3, 8)
    graph.addEdge(1, 4, 5)
    graph.addEdge(2, 4, 7)
    graph.addEdge(3, 4, 9)

    val mstWeight = primMST(graph)
    println("Total Weight of Minimum Spanning Tree (MST): $mstWeight")
}

fun primMST(graph: WeightedGraph): Int {
    val inMST = BooleanArray(graph.vertices)
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }) // Pair(node, edgeWeight)

    pq.add(Pair(0, 0)) // Start at vertex 0 with weight 0
    var totalMstWeight = 0

    while (pq.isNotEmpty()) {
        val (u, weight) = pq.poll()

        if (inMST[u]) continue

        inMST[u] = true
        totalMstWeight += weight

        for (edge in graph.adjMap[u] ?: emptyList()) {
            val v = edge.target
            if (!inMST[v]) {
                pq.add(Pair(v, edge.weight))
            }
        }
    }

    return totalMstWeight
}
