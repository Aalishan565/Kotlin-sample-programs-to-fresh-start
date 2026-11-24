package _7_tree._1_easy

import java.util.ArrayDeque

/**
 * _02_LevelOrderTraversalBFS.kt
 * Level-Order Traversal (Breadth-First Search - BFS) using a Queue (LeetCode #102).
 *
 * Beginner Explanation:
 * Process nodes level by level using a Queue.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(W) where W is maximum tree width
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.right?.right = TreeNode(5)

    println("--- Level-Order Traversal (BFS) ---")
    val levelOrderResult = levelOrderTraversal(root)
    println("Level Order by Levels: $levelOrderResult")
}

fun levelOrderTraversal(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val result = mutableListOf<List<Int>>()
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val currentLevel = mutableListOf<Int>()

        repeat(levelSize) {
            val node = queue.removeFirst()
            currentLevel.add(node.data)

            node.left?.let { queue.addLast(it) }
            node.right?.let { queue.addLast(it) }
        }

        result.add(currentLevel)
    }

    return result
}
