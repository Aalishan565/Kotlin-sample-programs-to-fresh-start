package _6_linked_list._2_medium

import _6_linked_list._1_easy.ListNode

/**
 * _03_DetectCycleInLinkedList.kt
 * Detects if a Linked List has a cycle/loop using Floyd's Tortoise and Hare Algorithm (LeetCode #141).
 *
 * Beginner Explanation:
 * Move `slow` pointer by 1 step and `fast` pointer by 2 steps.
 * If a cycle exists, `slow` and `fast` will eventually meet at the same node.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val head = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2 // Cycle back to node2

    println("--- Detect Loop in Linked List ---")
    val hasCycle = detectCycle(head)
    println("Does list contain a cycle? $hasCycle")
}

fun detectCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            return true // Cycle detected!
        }
    }

    return false
}
