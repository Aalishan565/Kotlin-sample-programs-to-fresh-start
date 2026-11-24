package _6_linked_list._2_medium

import _6_linked_list._1_easy.ListNode
import _6_linked_list._1_easy.printLinkedList

/**
 * _07_MergeTwoSortedLinkedLists.kt
 * Merges two sorted linked lists into one sorted linked list (LeetCode #21).
 *
 * Time Complexity: O(N + M)
 * Space Complexity: O(1) Auxiliary Space
 */
fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next?.next = ListNode(4)

    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next?.next = ListNode(5)

    println("--- Merge Two Sorted Linked Lists ---")
    println("List 1:")
    printLinkedList(l1)
    println("List 2:")
    printLinkedList(l2)

    val merged = mergeTwoLists(l1, l2)
    println("\nMerged Sorted List:")
    printLinkedList(merged)
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var current: ListNode? = dummy
    var p1 = l1
    var p2 = l2

    while (p1 != null && p2 != null) {
        if (p1.data <= p2.data) {
            current?.next = p1
            p1 = p1.next
        } else {
            current?.next = p2
            p2 = p2.next
        }
        current = current?.next
    }

    if (p1 != null) current?.next = p1
    if (p2 != null) current?.next = p2

    return dummy.next
}
