package _5_queue._1_easy

import java.util.ArrayDeque

/**
 * _03_QueueUsingTwoStacks.kt
 * Implements a FIFO Queue using two LIFO Stacks.
 *
 * Beginner Explanation:
 * - `stack1`: Stores incoming enqueued elements.
 * - `stack2`: Stores elements ready to be dequeued in FIFO order.
 * - When `stack2` is empty, pop all elements from `stack1` and push onto `stack2`.
 *
 * Time Complexity: Amortized O(1) for enqueue, dequeue, peek
 * Space Complexity: O(N)
 */
fun main() {
    println("--- Queue Using Two Stacks ---")
    val queue = QueueUsingTwoStacks()

    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)

    println("Size of queue: ${queue.getSizeOfQueue()}")
    println("Is empty?      : ${queue.isEmpty()}")
    println("Dequeued       : ${queue.dequeue()}")
    println("Dequeued       : ${queue.dequeue()}")

    queue.enqueue(5)
    queue.enqueue(6)
    println("Size of queue: ${queue.getSizeOfQueue()}")
    println("Dequeued       : ${queue.dequeue()}")
}

class QueueUsingTwoStacks {
    private val stack1 = ArrayDeque<Int>()
    private val stack2 = ArrayDeque<Int>()

    fun enqueue(data: Int) {
        stack1.push(data)
    }

    fun dequeue(): Int? {
        if (isEmpty()) return null
        moveStack1ToStack2()
        return stack2.pop()
    }

    fun peek(): Int? {
        if (isEmpty()) return null
        moveStack1ToStack2()
        return stack2.peek()
    }

    fun getSizeOfQueue(): Int {
        return stack1.size + stack2.size
    }

    fun isEmpty(): Boolean {
        return stack1.isEmpty() && stack2.isEmpty()
    }

    private fun moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (stack1.isNotEmpty()) {
                stack2.push(stack1.pop())
            }
        }
    }
}
