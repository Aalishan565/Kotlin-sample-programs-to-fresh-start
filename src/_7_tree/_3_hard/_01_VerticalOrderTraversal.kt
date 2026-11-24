package _7_tree._3_hard

import _7_tree._1_easy.TreeNode
import java.util.ArrayDeque

/**
 * _01_VerticalOrderTraversal.kt
 * Vertical Order Traversal of a Binary Tree using BFS and distance map (LeetCode #987).
 *
 * Beginner Explanation:
 * Assign horizontal distance `hd` to each node:
 * - Root has `hd = 0`.
 * - `node.left` has `hd - 1`.
 * - `node.right` has `hd + 1`.
 * Group node values by sorted `hd` column using a TreeMap.
 *
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(7)

    println("--- Vertical Order Traversal ---")
    val verticalNodesMap = verticalOrderTraversal(root)
    verticalNodesMap.forEach { (col, nodes) ->
        println("Column distance $col: $nodes")
    }
}

fun verticalOrderTraversal(root: TreeNode?): Map<Int, List<Int>> {
    if (root == null) return emptyMap()

    val map = sortedMapOf<Int, MutableList<Int>>()
    val queue = ArrayDeque<Pair<TreeNode, Int>>()
    queue.addLast(Pair(root, 0))

    while (queue.isNotEmpty()) {
        val (node, col) = queue.removeFirst()

        map.computeIfAbsent(col) { mutableListOf() }.add(node.data)

        node.left?.let { queue.addLast(Pair(it, col - 1)) }
        node.right?.let { queue.addLast(Pair(it, col + 1)) }
    }

    return map
}
