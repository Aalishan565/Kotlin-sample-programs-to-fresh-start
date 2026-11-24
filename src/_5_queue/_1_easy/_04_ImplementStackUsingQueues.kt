package _5_queue._1_easy

import java.util.ArrayDeque

/**
 * _04_ImplementStackUsingQueues.kt
 * Implements a LIFO Stack using a single Queue (LeetCode #225).
 *
 * Beginner Explanation:
 * When pushing element `x`, enqueue `x`, then rotate previous elements behind `x`.
 * This keeps the newest element at the front of the queue!
 *
 * Time Complexity: O(N) for push, O(1) for pop and top
 * Space Complexity: O(N)
 */
fun main() {
    println("--- Implement Stack Using Queues ---")
    val stack = MyStack()

    stack.push(1)
    stack.push(2)
    println("Top element (top): ${stack.top()}") // 2
    println("Popped element   : ${stack.pop()}") // 2
    println("Is stack empty?  : ${stack.empty()}") // false
}

class MyStack {
    private val queue = ArrayDeque<Int>()

    fun push(x: Int) {
        queue.addLast(x)
        // Rotate previous elements behind new element
        repeat(queue.size - 1) {
            queue.addLast(queue.removeFirst())
        }
    }

    fun pop(): Int {
        return queue.removeFirst()
    }

    fun top(): Int {
        return queue.first()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}
