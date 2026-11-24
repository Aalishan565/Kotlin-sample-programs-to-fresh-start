package _5_queue._1_easy

/**
 * _01_CustomLinkedListQueue.kt
 * Custom Queue implementation using a Singly Linked List (FIFO - First In First Out).
 *
 * Operations:
 * - enqueue(data): Adds element to rear - O(1)
 * - dequeue(): Removes and returns front element - O(1)
 * - peek(): Returns front element without removing - O(1)
 * - isEmpty(): Checks if queue is empty - O(1)
 */
fun main() {
    println("--- Custom Linked List Queue ---")
    val queue = LinkedListQueue<Int>()

    queue.enqueue(21)
    queue.enqueue(22)
    queue.enqueue(23)

    println("Current Queue:")
    queue.printQueue()

    println("\nDequeued element: ${queue.dequeue()}")
    println("Front element (peek): ${queue.peek()}")
    println("Current Size: ${queue.size()}")

    println("\nRemaining Queue:")
    queue.printQueue()
}

class LinkedListQueue<T> {
    private class Node<T>(val data: T, var next: Node<T>? = null)

    private var front: Node<T>? = null
    private var rear: Node<T>? = null
    private var count = 0

    fun enqueue(data: T) {
        val newNode = Node(data)
        if (isEmpty()) {
            front = newNode
            rear = newNode
        } else {
            rear?.next = newNode
            rear = newNode
        }
        count++
    }

    fun dequeue(): T? {
        if (isEmpty()) {
            println("Queue Underflow! Queue is empty.")
            return null
        }
        val dequeuedData = front?.data
        front = front?.next
        if (front == null) {
            rear = null
        }
        count--
        return dequeuedData
    }

    fun peek(): T? {
        return front?.data
    }

    fun isEmpty(): Boolean {
        return front == null
    }

    fun size(): Int {
        return count
    }

    fun printQueue() {
        if (isEmpty()) {
            println("Queue is empty.")
            return
        }
        var temp = front
        val elements = mutableListOf<T>()
        while (temp != null) {
            elements.add(temp.data)
            temp = temp.next
        }
        println("Front -> [${elements.joinToString(" -> ")}] -> Rear")
    }
}
