package _6_linked_list._1_easy

/**
 * _01_SinglyLinkedListNode.kt
 * Fundamental Singly Linked List Node definition, traversal (`printList`), and length calculation.
 *
 * Beginner Explanation:
 * A Singly Linked List is a linear data structure where each node contains `data` and a reference `next` to the next node.
 *
 * Operations:
 * - Traversal / Printing: O(N) Time, O(1) Space
 * - Length Calculation: O(N) Time, O(1) Space
 */
fun main() {
    val head = ListNode(1)
    val second = ListNode(2)
    val third = ListNode(3)
    val fourth = ListNode(4)

    head.next = second
    second.next = third
    third.next = fourth

    println("--- Singly Linked List Traversal & Length ---")
    printLinkedList(head)
    println("Length of Linked List: ${getLinkedListLength(head)}")
}

class ListNode(var data: Int) {
    var next: ListNode? = null
}

fun printLinkedList(head: ListNode?) {
    if (head == null) {
        println("List is empty.")
        return
    }
    var current = head
    val elements = mutableListOf<Int>()
    while (current != null) {
        elements.add(current.data)
        current = current.next
    }
    println("Head -> [${elements.joinToString(" -> ")}]")
}

fun getLinkedListLength(head: ListNode?): Int {
    var count = 0
    var current = head
    while (current != null) {
        count++
        current = current.next
    }
    return count
}
