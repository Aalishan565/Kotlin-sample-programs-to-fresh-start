package _7_tree._3_hard

import _7_tree._1_easy.TreeNode
import _7_tree._1_easy.inOrderRecursive

/**
 * _03_ConstructTreeFromPreorderAndInorder.kt
 * Reconstructs a unique Binary Tree from Preorder and Inorder traversal arrays (LeetCode #105).
 *
 * Beginner Explanation:
 * - Preorder first element is always the ROOT.
 * - Find root index in Inorder array: elements to left form Left Subtree, elements to right form Right Subtree!
 *
 * Time Complexity: O(N) using HashMap
 * Space Complexity: O(N)
 */
fun main() {
    val preorder = intArrayOf(3, 9, 20, 15, 7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)

    println("--- Reconstruct Tree from Preorder & Inorder ---")
    val reconstructedRoot = buildTree(preorder, inorder)

    print("Reconstructed In-Order Traversal: ")
    inOrderRecursive(reconstructedRoot)
    println()
}

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val inorderMap = inorder.indices.associateBy { inorder[it] }
    var preorderIndex = 0

    fun helper(left: Int, right: Int): TreeNode? {
        if (left > right) return null

        val rootVal = preorder[preorderIndex++]
        val root = TreeNode(rootVal)
        val inorderIndex = inorderMap[rootVal]!!

        root.left = helper(left, inorderIndex - 1)
        root.right = helper(inorderIndex + 1, right)

        return root
    }

    return helper(0, inorder.size - 1)
}
