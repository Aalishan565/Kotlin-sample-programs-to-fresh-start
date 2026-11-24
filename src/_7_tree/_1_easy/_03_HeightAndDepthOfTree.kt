package _7_tree._1_easy

import kotlin.math.max
import kotlin.math.min

/**
 * _03_HeightAndDepthOfTree.kt
 * Calculates Maximum Depth / Height (LeetCode #104) and Minimum Depth (LeetCode #111) of a Binary Tree.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)

    println("--- Height & Depth of Binary Tree ---")
    println("Maximum Depth (Height): ${maxDepth(root)}")
    println("Minimum Depth         : ${minDepth(root)}")
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + max(maxDepth(root.left), maxDepth(root.right))
}

fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    if (root.left == null && root.right == null) return 1

    if (root.left == null) return 1 + minDepth(root.right)
    if (root.right == null) return 1 + minDepth(root.left)

    return 1 + min(minDepth(root.left), minDepth(root.right))
}
