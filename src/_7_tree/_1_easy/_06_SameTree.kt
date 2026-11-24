package _7_tree._1_easy

/**
 * _06_SameTree.kt
 * Checks if two binary trees are identical in structure and node values (LeetCode #100).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
fun main() {
    val tree1 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }

    val tree2 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }

    println("--- Same Tree Check ---")
    println("Are tree1 and tree2 identical? ${isSameTree(tree1, tree2)}")
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false

    return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}
