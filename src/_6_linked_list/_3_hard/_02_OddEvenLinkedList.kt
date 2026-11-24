package _6_linked_list._3_hard

import _6_linked_list._1_easy.ListNode
import _6_linked_list._1_easy.printLinkedList

/**
 * _02_OddEvenLinkedList.kt
 * Group all odd-indexed nodes together followed by even-indexed nodes (LeetCode #328).
 *
 * Beginner Explanation:
 * Maintain `odd` pointer, `even` pointer, and `evenHead`.
 * Link odd nodes together (`odd.next = even.next`) and even nodes together (`even.next = odd.next`).
 * Append `evenHead` to the end of odd list (`odd.next = evenHead`).
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

    println("--- Odd Even Linked List ---")
    println("Original List:")
    printLinkedList(head)

    val segregatedHead = oddEvenList(head)
    println("\nSegregated List (Odds then Evens):")
    printLinkedList(segregatedHead)
}

fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null) return null

    var odd = head
    var even = head.next
    val evenHead = even

    while (even?.next != null) {
        odd?.next = even.next
        odd = odd?.next
        even.next = odd?.next
        even = even.next
    }

    odd?.next = evenHead
    return head
}
