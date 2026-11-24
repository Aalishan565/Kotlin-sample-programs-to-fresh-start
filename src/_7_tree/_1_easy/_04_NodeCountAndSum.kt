package _7_tree._1_easy

import kotlin.math.max

/**
 * _04_NodeCountAndSum.kt
 * Calculates total nodes, sum of all node values, and max element in a Binary Tree.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
fun main() {
    val root = TreeNode(10)
    root.left = TreeNode(20)
    root.right = TreeNode(30)
    root.left?.left = TreeNode(40)

    println("--- Node Count, Sum & Max Value ---")
    println("Total Nodes : ${countNodes(root)}")
    println("Sum of Nodes: ${sumOfNodes(root)}")
    println("Max Value   : ${maxElementInTree(root)}")
}

fun countNodes(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + countNodes(root.left) + countNodes(root.right)
}

fun sumOfNodes(root: TreeNode?): Int {
    if (root == null) return 0
    return root.data + sumOfNodes(root.left) + sumOfNodes(root.right)
}

fun maxElementInTree(root: TreeNode?): Int {
    if (root == null) return Int.MIN_VALUE
    val leftMax = maxElementInTree(root.left)
    val rightMax = maxElementInTree(root.right)
    return max(root.data, max(leftMax, rightMax))
}
