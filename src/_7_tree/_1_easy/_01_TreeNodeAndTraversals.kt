package _7_tree._1_easy

import java.util.ArrayDeque

/**
 * _01_TreeNodeAndTraversals.kt
 * Fundamental TreeNode class definition and Depth-First Search (DFS) Traversals:
 * 1. Pre-Order (Root -> Left -> Right)
 * 2. In-Order (Left -> Root -> Right)
 * 3. Post-Order (Left -> Right -> Root)
 * Both Recursive & Iterative implementations provided.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H) where H is tree height
 */
fun main() {
    println("--- Tree Node Traversals (DFS) ---")
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    print("Pre-Order  (Recursive): ")
    preOrderRecursive(root)
    println()

    print("Pre-Order  (Iterative): ")
    preOrderIterative(root)
    println()

    print("In-Order   (Recursive): ")
    inOrderRecursive(root)
    println()

    print("Post-Order (Recursive): ")
    postOrderRecursive(root)
    println()
}

class TreeNode(var data: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun preOrderRecursive(root: TreeNode?) {
    if (root == null) return
    print("${root.data} ")
    preOrderRecursive(root.left)
    preOrderRecursive(root.right)
}

fun inOrderRecursive(root: TreeNode?) {
    if (root == null) return
    inOrderRecursive(root.left)
    print("${root.data} ")
    inOrderRecursive(root.right)
}

fun postOrderRecursive(root: TreeNode?) {
    if (root == null) return
    postOrderRecursive(root.left)
    postOrderRecursive(root.right)
    print("${root.data} ")
}

fun preOrderIterative(root: TreeNode?) {
    if (root == null) return
    val stack = ArrayDeque<TreeNode>()
    stack.push(root)

    while (stack.isNotEmpty()) {
        val curr = stack.pop()
        print("${curr.data} ")

        // Push right first so left is processed first (LIFO)
        curr.right?.let { stack.push(it) }
        curr.left?.let { stack.push(it) }
    }
}
