package _7_tree._2_medium

import _7_tree._1_easy.TreeNode
import kotlin.math.max

/**
 * _04_DiameterOfBinaryTree.kt
 * Calculates the Diameter of a Binary Tree (length of longest path between any two nodes) (LeetCode #543).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    println("--- Diameter of Binary Tree ---")
    val diameter = diameterOfBinaryTree(root)
    println("Diameter (Max Edges Path): $diameter")
}

fun diameterOfBinaryTree(root: TreeNode?): Int {
    var maxDiameter = 0

    fun calculateHeight(node: TreeNode?): Int {
        if (node == null) return 0
        val leftHeight = calculateHeight(node.left)
        val rightHeight = calculateHeight(node.right)

        maxDiameter = max(maxDiameter, leftHeight + rightHeight)
        return 1 + max(leftHeight, rightHeight)
    }

    calculateHeight(root)
    return maxDiameter
}
