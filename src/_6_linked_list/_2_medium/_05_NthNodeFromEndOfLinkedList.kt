package _6_linked_list._2_medium

import _6_linked_list._1_easy.ListNode

/**
 * _05_NthNodeFromEndOfLinkedList.kt
 * Finds the N-th node from the end of a Linked List.
 *
 * Beginner Explanation:
 * Advance `fast` pointer by N steps first.
 * Then move both `slow` and `fast` pointers 1 step at a time until `fast` reaches null.
 * `slow` will be at the N-th node from the end!
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    val n = 2
    println("--- N-th Node From End ($n-th) ---")

    val nthNode = findNthFromEnd(head, n)
    println("$n-th node from end data: ${nthNode?.data}")
}

fun findNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null || n <= 0) return null

    var mainPtr = head
    var refPtr = head
    var count = 0

    while (count < n) {
        if (refPtr == null) return null // N is greater than list length
        refPtr = refPtr.next
        count++
    }

    while (refPtr != null) {
        mainPtr = mainPtr?.next
        refPtr = refPtr.next
    }

    return mainPtr
}
