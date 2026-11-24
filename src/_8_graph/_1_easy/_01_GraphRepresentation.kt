package _8_graph._1_easy

/**
 * _01_GraphRepresentation.kt
 * Demonstrates the two primary ways to represent a Graph:
 * 1. Adjacency Matrix (2D Array of size V x V) - O(1) edge lookup, O(V^2) space.
 * 2. Adjacency List (List of Lists/LinkedLists) - O(V + E) space (Most efficient for sparse graphs!).
 *
 * Space Complexity: O(V^2) for Matrix, O(V + E) for List
 */
fun main() {
    val vertices = 5

    println("--- 1. Graph Representation: Adjacency List ---")
    val adjList = GraphAdjacencyList(vertices)
    adjList.addEdge(0, 1)
    adjList.addEdge(0, 4)
    adjList.addEdge(1, 2)
    adjList.addEdge(1, 3)
    adjList.addEdge(1, 4)
    adjList.addEdge(2, 3)
    adjList.addEdge(3, 4)

    adjList.printGraph()

    println("\n--- 2. Graph Representation: Adjacency Matrix ---")
    val adjMatrix = GraphAdjacencyMatrix(vertices)
    adjMatrix.addEdge(0, 1)
    adjMatrix.addEdge(0, 4)
    adjMatrix.addEdge(1, 2)

    adjMatrix.printGraph()
}

class GraphAdjacencyList(val vertices: Int) {
    val adjMap = HashMap<Int, MutableList<Int>>()

    init {
        for (i in 0 until vertices) {
            adjMap[i] = mutableListOf()
        }
    }

    fun addEdge(source: Int, destination: Int, isDirected: Boolean = false) {
        adjMap[source]?.add(destination)
        if (!isDirected) {
            adjMap[destination]?.add(source)
        }
    }

    fun printGraph() {
        for (v in 0 until vertices) {
            println("Vertex $v -> ${adjMap[v]}")
        }
    }
}

class GraphAdjacencyMatrix(val vertices: Int) {
    private val matrix = Array(vertices) { IntArray(vertices) }

    fun addEdge(source: Int, destination: Int, isDirected: Boolean = false) {
        matrix[source][destination] = 1
        if (!isDirected) {
            matrix[destination][source] = 1
        }
    }

    fun printGraph() {
        for (row in matrix) {
            println(row.joinToString(" "))
        }
    }
}
