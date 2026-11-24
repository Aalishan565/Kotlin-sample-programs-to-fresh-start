package _8_graph._3_hard

/**
 * _02_BellmanFordShortestPath.kt
 * Bellman-Ford Shortest Path Algorithm handling negative edge weights & detecting negative cycles.
 *
 * Beginner Explanation:
 * Relaxes all E edges V - 1 times.
 * Running an additional V-th iteration detects if a negative weight cycle exists!
 *
 * Time Complexity: O(V * E)
 * Space Complexity: O(V)
 */
fun main() {
    println("--- Bellman-Ford Shortest Path Algorithm ---")
    val vertices = 5
    val edges = listOf(
        DirectedEdge(0, 1, -1),
        DirectedEdge(0, 2, 4),
        DirectedEdge(1, 2, 3),
        DirectedEdge(1, 3, 2),
        DirectedEdge(1, 4, 2),
        DirectedEdge(3, 2, 5),
        DirectedEdge(3, 1, 1),
        DirectedEdge(4, 3, -3)
    )

    val source = 0
    val distances = bellmanFord(vertices, edges, source)

    if (distances != null) {
        println("Shortest distances from Source $source:")
        for (i in distances.indices) {
            println("Distance to Node $i = ${distances[i]}")
        }
    } else {
        println("Graph contains a negative weight cycle!")
    }
}

data class DirectedEdge(val src: Int, val dest: Int, val weight: Int)

fun bellmanFord(vertices: Int, edges: List<DirectedEdge>, source: Int): IntArray? {
    val distances = IntArray(vertices) { Int.MAX_VALUE }
    distances[source] = 0

    // Relax all edges V - 1 times
    repeat(vertices - 1) {
        for (edge in edges) {
            if (distances[edge.src] != Int.MAX_VALUE && distances[edge.src] + edge.weight < distances[edge.dest]) {
                distances[edge.dest] = distances[edge.src] + edge.weight
            }
        }
    }

    // Check for negative weight cycles
    for (edge in edges) {
        if (distances[edge.src] != Int.MAX_VALUE && distances[edge.src] + edge.weight < distances[edge.dest]) {
            return null // Negative cycle detected!
        }
    }

    return distances
}
