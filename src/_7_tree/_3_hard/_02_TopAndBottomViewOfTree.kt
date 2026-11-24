package _7_tree._3_hard

import _7_tree._1_easy.TreeNode
import java.util.ArrayDeque

/**
 * _02_TopAndBottomViewOfTree.kt
 * Computes Top View and Bottom View of a Binary Tree.
 *
 * Beginner Explanation:
 * Use Level-Order BFS with horizontal distance `hd`:
 * - Top View: Record the FIRST node encountered at each `hd`.
 * - Bottom View: Continually OVERWRITE node at each `hd` so the LAST node remains.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.left?.right?.right = TreeNode(5)
    root.left?.right?.right?.right = TreeNode(6)

    println("--- Top View & Bottom View ---")
    println("Top View   : ${topView(root)}")
    println("Bottom View: ${bottomView(root)}")
}

fun topView(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()

    val topMap = sortedMapOf<Int, Int>() // hd -> first node data
    val queue = ArrayDeque<Pair<TreeNode, Int>>()
    queue.addLast(Pair(root, 0))

    while (queue.isNotEmpty()) {
        val (node, hd) = queue.removeFirst()

        if (!topMap.containsKey(hd)) {
            topMap[hd] = node.data
        }

        node.left?.let { queue.addLast(Pair(it, hd - 1)) }
        node.right?.let { queue.addLast(Pair(it, hd + 1)) }
    }

    return topMap.values.toList()
}

fun bottomView(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()

    val bottomMap = sortedMapOf<Int, Int>() // hd -> last node data
    val queue = ArrayDeque<Pair<TreeNode, Int>>()
    queue.addLast(Pair(root, 0))

    while (queue.isNotEmpty()) {
        val (node, hd) = queue.removeFirst()

        bottomMap[hd] = node.data // Always overwrite

        node.left?.let { queue.addLast(Pair(it, hd - 1)) }
        node.right?.let { queue.addLast(Pair(it, hd + 1)) }
    }

    return bottomMap.values.toList()
}
