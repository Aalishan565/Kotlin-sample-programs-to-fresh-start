package _6_linked_list._1_easy

/**
 * _02_SinglyLinkedListInsert.kt
 * Demonstrates node insertion in a Singly Linked List.
 *
 * Operations:
 * - Insert at Beginning (Head): O(1) Time
 * - Insert at End (Tail): O(N) Time
 * - Insert at Specific Position: O(N) Time
 */
fun main() {
    println("--- Singly Linked List Insertion ---")
    var head: ListNode? = ListNode(10)
    head?.next = ListNode(20)

    println("Original List:")
    printLinkedList(head)

    // Insert at Beginning
    head = insertAtBeginning(head, 5)
    println("\nAfter Insert 5 at Beginning:")
    printLinkedList(head)

    // Insert at Last
    head = insertAtLast(head, 30)
    println("\nAfter Insert 30 at Last:")
    printLinkedList(head)

    // Insert at Position 3
    head = insertAtPosition(head, 15, position = 3)
    println("\nAfter Insert 15 at Position 3:")
    printLinkedList(head)
}

fun insertAtBeginning(head: ListNode?, value: Int): ListNode {
    val newNode = ListNode(value)
    newNode.next = head
    return newNode
}

fun insertAtLast(head: ListNode?, value: Int): ListNode {
    val newNode = ListNode(value)
    if (head == null) return newNode

    var current = head
    while (current?.next != null) {
        current = current.next
    }
    current?.next = newNode
    return head
}

fun insertAtPosition(head: ListNode?, value: Int, position: Int): ListNode {
    if (position == 1) {
        return insertAtBeginning(head, value)
    }

    val newNode = ListNode(value)
    var current = head
    var count = 1

    while (count < position - 1 && current != null) {
        current = current.next
        count++
    }

    if (current != null) {
        newNode.next = current.next
        current.next = newNode
    }

    return head ?: newNode
}
