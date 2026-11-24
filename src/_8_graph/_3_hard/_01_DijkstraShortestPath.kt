package _8_graph._3_hard

import java.util.PriorityQueue

/**
 * _01_DijkstraShortestPath.kt
 * Dijkstra's Single-Source Shortest Path Algorithm using PriorityQueue (Min-Heap).
 *
 * Beginner Explanation:
 * Finds shortest distance from source node to all other nodes in a weighted graph with non-negative edge weights.
 * Greedy Choice: Always process the unvisited node with smallest tentative distance.
 *
 * Time Complexity: O((V + E) log V)
 * Space Complexity: O(V + E)
 */
fun main() {
    println("--- Dijkstra's Shortest Path Algorithm ---")
    val graph = WeightedGraph(vertices = 5)
    graph.addEdge(0, 1, 4)
    graph.addEdge(0, 2, 1)
    graph.addEdge(2, 1, 2)
    graph.addEdge(1, 3, 1)
    graph.addEdge(2, 3, 5)
    graph.addEdge(3, 4, 3)

    val source = 0
    val distances = dijkstra(graph, source)

    println("Shortest distances from Source $source:")
    for (i in distances.indices) {
        println("Distance to Node $i = ${distances[i]}")
    }
}

data class Edge(val target: Int, val weight: Int)

class WeightedGraph(val vertices: Int) {
    val adjMap = HashMap<Int, MutableList<Edge>>()

    init {
        for (i in 0 until vertices) {
            adjMap[i] = mutableListOf()
        }
    }

    fun addEdge(source: Int, destination: Int, weight: Int, isDirected: Boolean = false) {
        adjMap[source]?.add(Edge(destination, weight))
        if (!isDirected) {
            adjMap[destination]?.add(Edge(source, weight))
        }
    }
}

fun dijkstra(graph: WeightedGraph, source: Int): IntArray {
    val distances = IntArray(graph.vertices) { Int.MAX_VALUE }
    distances[source] = 0

    // PriorityQueue storing Pair(node, currentDistance) ordered by smallest distance
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    pq.add(Pair(source, 0))

    while (pq.isNotEmpty()) {
        val (u, currentDist) = pq.poll()

        if (currentDist > distances[u]) continue

        for (edge in graph.adjMap[u] ?: emptyList()) {
            val v = edge.target
            val weight = edge.weight

            if (distances[u] + weight < distances[v]) {
                distances[v] = distances[u] + weight
                pq.add(Pair(v, distances[v]))
            }
        }
    }

    return distances
}
