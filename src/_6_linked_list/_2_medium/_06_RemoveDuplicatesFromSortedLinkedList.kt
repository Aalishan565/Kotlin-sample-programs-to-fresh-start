package _6_linked_list._2_medium

import _6_linked_list._1_easy.ListNode
import _6_linked_list._1_easy.printLinkedList

/**
 * _06_RemoveDuplicatesFromSortedLinkedList.kt
 * Removes duplicate nodes from a sorted Linked List (LeetCode #83).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val head = ListNode(1)
    head.next = ListNode(1)
    head.next?.next = ListNode(2)
    head.next?.next?.next = ListNode(3)
    head.next?.next?.next?.next = ListNode(3)

    println("--- Remove Duplicates from Sorted Linked List ---")
    println("Original List:")
    printLinkedList(head)

    val uniqueHead = removeDuplicates(head)
    println("\nUnique Elements List:")
    printLinkedList(uniqueHead)
}

fun removeDuplicates(head: ListNode?): ListNode? {
    var current = head

    while (current?.next != null) {
        if (current.data == current.next!!.data) {
            current.next = current.next!!.next // Skip duplicate node
        } else {
            current = current.next
        }
    }

    return head
}
