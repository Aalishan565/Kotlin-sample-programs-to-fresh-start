package _6_linked_list._1_easy

/**
 * _06_InsertInSortedLinkedList.kt
 * Inserts a new value into a sorted Singly Linked List maintaining sorted order.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val head = ListNode(10)
    head.next = ListNode(20)
    head.next?.next = ListNode(40)

    println("--- Insert Element in Sorted Linked List ---")
    println("Original Sorted List:")
    printLinkedList(head)

    val updatedHead = insertInSortedList(head, 30)
    println("\nAfter Inserting 30:")
    printLinkedList(updatedHead)
}

fun insertInSortedList(head: ListNode?, value: Int): ListNode {
    val newNode = ListNode(value)

    if (head == null || value < head.data) {
        newNode.next = head
        return newNode
    }

    var current = head
    while (current?.next != null && current.next!!.data < value) {
        current = current.next
    }

    newNode.next = current?.next
    current?.next = newNode

    return head
}
