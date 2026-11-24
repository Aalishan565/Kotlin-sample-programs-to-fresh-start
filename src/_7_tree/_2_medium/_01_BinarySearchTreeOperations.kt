package _7_tree._2_medium

import _7_tree._1_easy.TreeNode
import _7_tree._1_easy.inOrderRecursive

/**
 * _01_BinarySearchTreeOperations.kt
 * Demonstrates Binary Search Tree (BST) operations: Insert, Search, and Delete Node (LeetCode #700 & #450).
 *
 * BST Property: For every node `X`, all nodes in left subtree < `X`, and all nodes in right subtree > `X`.
 *
 * Time Complexity: O(H) Average (O(log N) balanced, O(N) worst case)
 * Space Complexity: O(H)
 */
fun main() {
    println("--- Binary Search Tree (BST) Operations ---")
    var bstRoot: TreeNode? = null

    for (value in listOf(50, 30, 20, 40, 70, 60, 80)) {
        bstRoot = insertBst(bstRoot, value)
    }

    print("In-Order Traversal (Sorted Order): ")
    inOrderRecursive(bstRoot)
    println()

    val searchKey = 60
    println("Search $searchKey in BST: ${searchBst(bstRoot, searchKey)}")

    println("\nDeleting node 20...")
    bstRoot = deleteBstNode(bstRoot, 20)
    print("In-Order After Deletion: ")
    inOrderRecursive(bstRoot)
    println()
}

fun insertBst(root: TreeNode?, value: Int): TreeNode {
    if (root == null) return TreeNode(value)

    if (value < root.data) {
        root.left = insertBst(root.left, value)
    } else if (value > root.data) {
        root.right = insertBst(root.right, value)
    }

    return root
}

fun searchBst(root: TreeNode?, key: Int): Boolean {
    if (root == null) return false
    if (root.data == key) return true

    return if (key < root.data) {
        searchBst(root.left, key)
    } else {
        searchBst(root.right, key)
    }
}

fun deleteBstNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) return null

    if (key < root.data) {
        root.left = deleteBstNode(root.left, key)
    } else if (key > root.data) {
        root.right = deleteBstNode(root.right, key)
    } else {
        // Node with only one child or no child
        if (root.left == null) return root.right
        if (root.right == null) return root.left

        // Node with two children: get in-order successor (smallest in right subtree)
        var minNode = root.right
        while (minNode?.left != null) {
            minNode = minNode.left
        }
        root.data = minNode!!.data
        root.right = deleteBstNode(root.right, minNode.data)
    }

    return root
}
