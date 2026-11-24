package _3_arrays._2_medium

import java.util.ArrayDeque

/**
 * _19_NextGreaterElementInArray.kt
 * Finds the Next Greater Element (NGE) for each element in an array using a Stack in O(N) time.
 */
fun main() {
    val array = intArrayOf(4, 8, 5, 2, 13, 25, 12, 7)

    println("--- Next Greater Element (NGE) ---")
    println("Input Array: ${array.joinToString(", ")}")
    nextGreaterElementStack(array)
}

fun nextGreaterElementStack(array: IntArray) {
    val stack = ArrayDeque<Int>()

    for (num in array) {
        while (stack.isNotEmpty() && stack.peek() < num) {
            println("NGE of ${stack.pop()} -> $num")
        }
        stack.push(num)
    }

    while (stack.isNotEmpty()) {
        println("NGE of ${stack.pop()} -> -1 (No greater element)")
    }
}
