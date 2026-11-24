package _7_tree._2_medium

import _7_tree._1_easy.TreeNode

/**
 * _05_RightAndLeftViewOfTree.kt
 * Computes Right Side View (LeetCode #199) and Left Side View of a Binary Tree.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.right = TreeNode(5)
    root.right?.right = TreeNode(4)

    println("--- Right & Left Side Views ---")
    println("Right Side View: ${rightSideView(root)}")
    println("Left Side View : ${leftSideView(root)}")
}

fun rightSideView(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun dfs(node: TreeNode?, depth: Int) {
        if (node == null) return
        if (depth == result.size) {
            result.add(node.data)
        }
        dfs(node.right, depth + 1) // Right first
        dfs(node.left, depth + 1)
    }

    dfs(root, 0)
    return result
}

fun leftSideView(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun dfs(node: TreeNode?, depth: Int) {
        if (node == null) return
        if (depth == result.size) {
            result.add(node.data)
        }
        dfs(node.left, depth + 1) // Left first
        dfs(node.right, depth + 1)
    }

    dfs(root, 0)
    return result
}
