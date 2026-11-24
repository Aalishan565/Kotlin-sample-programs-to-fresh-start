package _6_linked_list._1_easy

/**
 * _03_SinglyLinkedListDelete.kt
 * Demonstrates node deletion in a Singly Linked List.
 *
 * Operations:
 * - Delete Head: O(1) Time
 * - Delete Last Node (Tail): O(N) Time
 */
fun main() {
    println("--- Singly Linked List Deletion ---")
    var head: ListNode? = ListNode(10)
    head?.next = ListNode(20)
    head?.next?.next = ListNode(30)
    head?.next?.next?.next = ListNode(40)

    println("Original List:")
    printLinkedList(head)

    // Delete Head
    head = deleteHead(head)
    println("\nAfter Deleting Head:")
    printLinkedList(head)

    // Delete Last Node
    head = deleteLastNode(head)
    println("\nAfter Deleting Last Node:")
    printLinkedList(head)
}

fun deleteHead(head: ListNode?): ListNode? {
    if (head == null) return null
    val newHead = head.next
    head.next = null
    return newHead
}

fun deleteLastNode(head: ListNode?): ListNode? {
    if (head?.next == null) return null

    var current = head
    var previous: ListNode? = null

    while (current?.next != null) {
        previous = current
        current = current.next
    }

    previous?.next = null
    return head
}
