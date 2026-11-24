package _6_linked_list._2_medium

import java.util.NoSuchElementException

/**
 * _01_DoublyLinkedList.kt
 * Doubly Linked List implementation supporting forward & backward traversal, head/tail insertion and deletion.
 *
 * Time Complexity: O(1) for head & tail insertion/deletion
 * Space Complexity: O(N)
 */
fun main() {
    println("--- Doubly Linked List Operations ---")
    val dll = DoublyLinkedList()

    dll.insertHead(3)
    dll.insertHead(2)
    dll.insertHead(1)
    dll.insertTail(4)

    println("Forward Traversal:")
    dll.displayForward()

    println("\nBackward Traversal:")
    dll.displayBackward()

    println("\nDeleted Head: ${dll.deleteHead()?.data}")
    println("Deleted Tail: ${dll.deleteTail()?.data}")

    println("\nForward Traversal After Deletions:")
    dll.displayForward()
}

class DoublyLinkedList {
    class DoubleListNode(var data: Int) {
        var next: DoubleListNode? = null
        var prev: DoubleListNode? = null
    }

    private var head: DoubleListNode? = null
    private var tail: DoubleListNode? = null
    private var count = 0

    fun isEmpty(): Boolean = count == 0

    fun size(): Int = count

    fun insertHead(data: Int) {
        val newNode = DoubleListNode(data)
        if (isEmpty()) {
            tail = newNode
        } else {
            head?.prev = newNode
        }
        newNode.next = head
        head = newNode
        count++
    }

    fun insertTail(data: Int) {
        val newNode = DoubleListNode(data)
        if (isEmpty()) {
            head = newNode
        } else {
            tail?.next = newNode
            newNode.prev = tail
        }
        tail = newNode
        count++
    }

    fun deleteHead(): DoubleListNode? {
        if (isEmpty()) throw NoSuchElementException("List is empty")
        val temp = head
        if (head == tail) {
            tail = null
        } else {
            head?.next?.prev = null
        }
        head = head?.next
        temp?.next = null
        count--
        return temp
    }

    fun deleteTail(): DoubleListNode? {
        if (isEmpty()) throw NoSuchElementException("List is empty")
        val temp = tail
        if (head == tail) {
            head = null
        } else {
            tail?.prev?.next = null
        }
        tail = tail?.prev
        temp?.prev = null
        count--
        return temp
    }

    fun displayForward() {
        var current = head
        val elements = mutableListOf<Int>()
        while (current != null) {
            elements.add(current.data)
            current = current.next
        }
        println("Head -> [${elements.joinToString(" <-> ")}]")
    }

    fun displayBackward() {
        var current = tail
        val elements = mutableListOf<Int>()
        while (current != null) {
            elements.add(current.data)
            current = current.prev
        }
        println("Tail -> [${elements.joinToString(" <-> ")}]")
    }
}
