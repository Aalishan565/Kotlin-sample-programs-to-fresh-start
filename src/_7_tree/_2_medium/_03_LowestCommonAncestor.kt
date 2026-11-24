package _7_tree._2_medium

import _7_tree._1_easy.TreeNode

/**
 * _03_LowestCommonAncestor.kt
 * Finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Tree (LeetCode #236).
 *
 * Beginner Explanation:
 * Recurse left and right:
 * - If current node equals `p` or `q`, return current node.
 * - If both left and right return non-null, current node is the LCA!
 * - Else return whichever subtree returned non-null.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
fun main() {
    val root = TreeNode(3)
    val p = TreeNode(5)
    val q = TreeNode(1)

    root.left = p
    root.right = q
    root.left?.left = TreeNode(6)
    root.left?.right = TreeNode(2)

    println("--- Lowest Common Ancestor (LCA) ---")
    val lcaNode = lowestCommonAncestor(root, p, q)
    println("LCA of ${p.data} and ${q.data} is: ${lcaNode?.data}")
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || root == p || root == q) return root

    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    if (left != null && right != null) return root

    return left ?: right
}
