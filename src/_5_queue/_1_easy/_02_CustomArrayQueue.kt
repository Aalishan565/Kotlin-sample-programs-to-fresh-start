package _5_queue._1_easy

/**
 * _02_CustomArrayQueue.kt
 * Custom Queue implementation using a fixed-size Array.
 *
 * Time Complexity: O(1) for enqueue, dequeue, peek, isEmpty, isFull
 * Space Complexity: O(N) where N is capacity
 */
fun main() {
    println("--- Custom Array Queue ---")
    val queue = ArrayQueue(capacity = 5)

    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)

    println("Front element (peek): ${queue.peek()}")
    println("Dequeued: ${queue.dequeue()}")
    println("Dequeued: ${queue.dequeue()}")

    println("Is Empty? ${queue.isEmpty()}")
    println("Current Size: ${queue.size()}")
}

class ArrayQueue(private val capacity: Int) {
    private val array = IntArray(capacity)
    private var front = 0
    private var rear = -1
    private var count = 0

    fun enqueue(element: Int) {
        if (isFull()) {
            println("Queue Overflow! Cannot enqueue $element")
            return
        }
        rear = (rear + 1) % capacity
        array[rear] = element
        count++
    }

    fun dequeue(): Int? {
        if (isEmpty()) {
            println("Queue Underflow! Cannot dequeue from empty queue")
            return null
        }
        val element = array[front]
        front = (front + 1) % capacity
        count--
        return element
    }

    fun peek(): Int? {
        if (isEmpty()) return null
        return array[front]
    }

    fun isEmpty(): Boolean = count == 0

    fun isFull(): Boolean = count == capacity

    fun size(): Int = count
}
