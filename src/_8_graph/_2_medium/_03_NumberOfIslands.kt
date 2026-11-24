package _8_graph._2_medium

/**
 * _03_NumberOfIslands.kt
 * Counts the number of islands (connected components of '1's surrounded by '0's) in a 2D grid (LeetCode #200).
 *
 * Beginner Explanation:
 * Iterate through 2D grid. When encountering an unvisited '1', increment island count and use DFS to sink/mark all connected '1's as '0'.
 *
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) recursion stack
 */
fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '1')
    )

    println("--- Number of Islands ---")
    val islands = numIslands(grid)
    println("Total Islands Count: $islands")
}

fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    var count = 0

    fun dfsSink(r: Int, c: Int) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') return

        grid[r][c] = '0' // Sink island cell

        // Explore 4 directions (up, down, left, right)
        dfsSink(r + 1, c)
        dfsSink(r - 1, c)
        dfsSink(r, c + 1)
        dfsSink(r, c - 1)
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == '1') {
                count++
                dfsSink(r, c)
            }
        }
    }

    return count
}
