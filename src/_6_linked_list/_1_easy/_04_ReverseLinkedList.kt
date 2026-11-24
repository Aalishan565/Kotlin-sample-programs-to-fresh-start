package _6_linked_list._1_easy

/**
 * _04_ReverseLinkedList.kt
 * Reverses a Singly Linked List iteratively and recursively (LeetCode #206).
 *
 * Beginner Explanation:
 * - Iterative: Maintain three pointers (`previous`, `current`, `next`) and flip `current.next = previous`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1) Iterative, O(N) Recursive
 */
fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)

    println("--- Reverse Singly Linked List ---")
    println("Original List:")
    printLinkedList(head)

    val reversedIterative = reverseListIterative(head)
    println("\nReversed (Iterative):")
    printLinkedList(reversedIterative)
}

fun reverseListIterative(head: ListNode?): ListNode? {
    var current = head
    var previous: ListNode? = null
    var next: ListNode? = null

    while (current != null) {
        next = current.next       // Store next node
        current.next = previous   // Flip link backward
        previous = current        // Move previous forward
        current = next            // Move current forward
    }

    return previous // New head
}

fun reverseListRecursive(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val newHead = reverseListRecursive(head.next)
    head.next?.next = head
    head.next = null

    return newHead
}
