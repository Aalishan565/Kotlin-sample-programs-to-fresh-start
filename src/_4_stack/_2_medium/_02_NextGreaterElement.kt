package _4_stack._2_medium

import java.util.ArrayDeque

/**
 * _02_NextGreaterElement.kt
 * Finds Next Greater Element (NGE) for each element in an array using Monotonic Stack.
 *
 * Beginner Explanation:
 * Maintain a stack of elements waiting for a larger value.
 * When encountering `num > stack.peek()`, pop elements and map `element -> NGE`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val array = intArrayOf(4, 5, 2, 25, 7, 8)

    println("--- Next Greater Element ---")
    println("Input Array: ${array.joinToString(", ")}")

    val ngeResult = nextGreaterElement(array)
    for (i in array.indices) {
        println("NGE of ${array[i]} -> ${ngeResult[i]}")
    }
}

fun nextGreaterElement(array: IntArray): IntArray {
    val result = IntArray(array.size) { -1 }
    val stack = ArrayDeque<Int>() // Stack stores indices

    for (i in array.indices) {
        while (stack.isNotEmpty() && array[stack.peek()!!] < array[i]) {
            val poppedIndex = stack.pop()
            result[poppedIndex] = array[i]
        }
        stack.push(i)
    }

    return result
}
