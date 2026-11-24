package _4_stack._1_easy

import java.util.ArrayDeque

/**
 * _04_ImplementQueueUsingStacks.kt
 * Implements a FIFO Queue using two LIFO Stacks (LeetCode #232).
 *
 * Beginner Explanation:
 * Maintain `inStack` for enqueuing and `outStack` for dequeuing.
 * When `outStack` is empty, transfer all elements from `inStack` to `outStack` (reversing their order to FIFO!).
 *
 * Amortized Time Complexity: O(1) for push, pop, peek
 * Space Complexity: O(N)
 */
fun main() {
    println("--- Implement Queue Using Stacks ---")
    val queue = MyQueue()

    queue.push(1)
    queue.push(2)
    println("Peek top of queue: ${queue.peek()}") // 1
    println("Pop from queue   : ${queue.pop()}")  // 1
    println("Is queue empty?  : ${queue.empty()}") // false
}

class MyQueue {
    private val inStack = ArrayDeque<Int>()
    private val outStack = ArrayDeque<Int>()

    fun push(x: Int) {
        inStack.push(x)
    }

    fun pop(): Int {
        moveInToOut()
        return outStack.pop()
    }

    fun peek(): Int {
        moveInToOut()
        return outStack.peek()!!
    }

    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }

    private fun moveInToOut() {
        if (outStack.isEmpty()) {
            while (inStack.isNotEmpty()) {
                outStack.push(inStack.pop())
            }
        }
    }
}
