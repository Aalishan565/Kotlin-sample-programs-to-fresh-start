package _4_stack._2_medium

import java.util.ArrayDeque
import kotlin.math.min

/**
 * _01_MinStack.kt
 * Designs a Stack that supports push, pop, top, and retrieving the minimum element in O(1) time (LeetCode #155).
 *
 * Beginner Explanation:
 * Maintain a main stack for values and an auxiliary `minStack` tracking the minimum value at each depth.
 *
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(N)
 */
fun main() {
    println("--- Min Stack ---")
    val minStack = MinStack()

    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)

    println("Current Minimum: ${minStack.getMin()}") // -3
    minStack.pop()
    println("Top Element    : ${minStack.top()}")    // 0
    println("Current Minimum: ${minStack.getMin()}") // -2
}

class MinStack {
    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()

    fun push(valNum: Int) {
        stack.push(valNum)
        val currentMin = if (minStack.isEmpty()) valNum else min(valNum, minStack.peek()!!)
        minStack.push(currentMin)
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()!!
    }

    fun getMin(): Int {
        return minStack.peek()!!
    }
}
