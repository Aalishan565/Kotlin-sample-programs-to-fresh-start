package _7_tree._3_hard

import _7_tree._1_easy.TreeNode
import kotlin.math.max

/**
 * _04_BinaryTreeMaxPathSum.kt
 * Finds the maximum path sum in a Binary Tree (path can start and end at any node) (LeetCode #124).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
fun main() {
    val root = TreeNode(-10).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    println("--- Binary Tree Maximum Path Sum ---")
    val maxSum = maxPathSum(root)
    println("Maximum Path Sum: $maxSum")
}

fun maxPathSum(root: TreeNode?): Int {
    var maxGlobalSum = Int.MIN_VALUE

    fun maxGain(node: TreeNode?): Int {
        if (node == null) return 0

        val leftGain = max(0, maxGain(node.left))
        val rightGain = max(0, maxGain(node.right))

        val currentPathSum = node.data + leftGain + rightGain
        maxGlobalSum = max(maxGlobalSum, currentPathSum)

        return node.data + max(leftGain, rightGain)
    }

    maxGain(root)
    return maxGlobalSum
}
