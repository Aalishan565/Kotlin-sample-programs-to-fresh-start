package _5_queue._2_medium

/**
 * _01_DesignCircularQueue.kt
 * Designs a Circular Queue (Ring Buffer) with fixed capacity (LeetCode #622).
 *
 * Beginner Explanation:
 * Reuses empty space created by dequeue operations by connecting front and rear circularly using modulo arithmetic:
 * `rear = (rear + 1) % capacity`.
 *
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(K) where K is capacity
 */
fun main() {
    println("--- Design Circular Queue ---")
    val circularQueue = MyCircularQueue(3)

    println("enQueue(1): ${circularQueue.enQueue(1)}") // true
    println("enQueue(2): ${circularQueue.enQueue(2)}") // true
    println("enQueue(3): ${circularQueue.enQueue(3)}") // true
    println("enQueue(4): ${circularQueue.enQueue(4)}") // false (Full)

    println("Front element: ${circularQueue.Front()}") // 1
    println("Rear element : ${circularQueue.Rear()}")  // 3
    println("Is Full?     : ${circularQueue.isFull()}")// true
    println("deQueue()    : ${circularQueue.deQueue()}") // true
    println("enQueue(4)   : ${circularQueue.enQueue(4)}") // true
    println("Rear element : ${circularQueue.Rear()}")  // 4
}

class MyCircularQueue(k: Int) {
    private val queue = IntArray(k)
    private var head = 0
    private var tail = -1
    private var size = 0
    private val capacity = k

    fun enQueue(value: Int): Boolean {
        if (isFull()) return false
        tail = (tail + 1) % capacity
        queue[tail] = value
        size++
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        head = (head + 1) % capacity
        size--
        return true
    }

    fun Front(): Int {
        return if (isEmpty()) -1 else queue[head]
    }

    fun Rear(): Int {
        return if (isEmpty()) -1 else queue[tail]
    }

    fun isEmpty(): Boolean = size == 0

    fun isFull(): Boolean = size == capacity
}
