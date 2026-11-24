package _7_tree._1_easy

/**
 * _05_InvertBinaryTree.kt
 * Inverts / Mirror-images a Binary Tree (LeetCode #226).
 *
 * Beginner Explanation:
 * Swap `left` and `right` subtrees at each node recursively.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)

    println("--- Invert Binary Tree ---")
    println("Original In-Order:")
    inOrderRecursive(root)

    val invertedRoot = invertTree(root)
    println("\nInverted In-Order:")
    inOrderRecursive(invertedRoot)
    println()
}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val temp = root.left
    root.left = invertTree(root.right)
    root.right = invertTree(temp)

    return root
}
