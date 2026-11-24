package _6_linked_list._2_medium

import java.util.NoSuchElementException

/**
 * _02_CircularSinglyLinkedList.kt
 * Circular Singly Linked List implementation where the last node points back to the head node.
 *
 * Time Complexity: O(1) for head/tail insertions and head deletion
 * Space Complexity: O(N)
 */
fun main() {
    println("--- Circular Singly Linked List ---")
    val cll = CircularSinglyLinkedList()

    cll.insertBeginning(10)
    cll.insertEnd(20)
    cll.insertEnd(30)

    println("Circular List Elements:")
    cll.printList()

    println("\nRemoved First Node:")
    cll.removeFirstNode()
    cll.printList()
}

class CircularSinglyLinkedList {
    class CircularNode(var data: Int) {
        var next: CircularNode? = null
    }

    private var last: CircularNode? = null
    private var count = 0

    fun isEmpty(): Boolean = count == 0

    fun size(): Int = count

    fun printList() {
        if (last == null) {
            println("Circular List is empty.")
            return
        }
        val elements = mutableListOf<Int>()
        var current = last?.next
        val first = current

        while (current != null) {
            elements.add(current.data)
            current = current.next
            if (current == first) break
        }

        println("[${elements.joinToString(" -> ")}] -> (Back to Start)")
    }

    fun insertBeginning(data: Int) {
        val newNode = CircularNode(data)
        if (last == null) {
            last = newNode
            last?.next = last
        } else {
            newNode.next = last?.next
            last?.next = newNode
        }
        count++
    }

    fun insertEnd(data: Int) {
        val newNode = CircularNode(data)
        if (last == null) {
            last = newNode
            last?.next = last
        } else {
            newNode.next = last?.next
            last?.next = newNode
            last = newNode
        }
        count++
    }

    fun removeFirstNode() {
        if (isEmpty()) throw NoSuchElementException("List is empty")

        val first = last?.next
        if (last?.next == last) {
            last = null
        } else {
            last?.next = first?.next
        }
        first?.next = null
        count--
    }
}
