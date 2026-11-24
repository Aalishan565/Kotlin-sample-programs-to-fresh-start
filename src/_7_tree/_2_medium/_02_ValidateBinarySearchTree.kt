package _7_tree._2_medium

import _7_tree._1_easy.TreeNode

/**
 * _02_ValidateBinarySearchTree.kt
 * Validates if a binary tree is a valid Binary Search Tree (BST) (LeetCode #98).
 *
 * Beginner Explanation:
 * Check if every node falls within valid range `(min < val < max)`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
fun main() {
    val validBst = TreeNode(2).apply {
        left = TreeNode(1)
        right = TreeNode(3)
    }

    val invalidBst = TreeNode(5).apply {
        left = TreeNode(1)
        right = TreeNode(4).apply {
            left = TreeNode(3)
            right = TreeNode(6)
        }
    }

    println("--- Validate Binary Search Tree ---")
    println("Valid BST Check  : ${isValidBST(validBst)}")
    println("Invalid BST Check: ${isValidBST(invalidBst)}")
}

fun isValidBST(root: TreeNode?): Boolean {
    return validate(root, null, null)
}

private fun validate(node: TreeNode?, minVal: Int?, maxVal: Int?): Boolean {
    if (node == null) return true

    if (minVal != null && node.data <= minVal) return false
    if (maxVal != null && node.data >= maxVal) return false

    return validate(node.left, minVal, node.data) && validate(node.right, node.data, maxVal)
}
