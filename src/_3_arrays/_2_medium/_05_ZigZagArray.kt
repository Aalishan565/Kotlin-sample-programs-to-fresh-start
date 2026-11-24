package _3_arrays._2_medium

/**
 * _05_ZigZagArray.kt
 * Rearranges an array in zig-zag fashion: a < b > c < d > e < f...
 *
 * Beginner Explanation:
 * Iterates through the array alternating relations:
 * - At even indices, `a[i] < a[i+1]` is expected.
 * - At odd indices, `a[i] > a[i+1]` is expected.
 * Swaps adjacent elements whenever condition is violated.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(6, 5, 4, 3, 2, 1)

    println("--- Zig-Zag Array Rearrangement ---")
    println("Original Array: ${array.joinToString(", ")}")

    convertToZigZag(array)
    println("Zig-Zag Array : ${array.joinToString(", ")}")
}

fun convertToZigZag(array: IntArray) {
    var flag = true

    for (i in 0 until array.size - 1) {
        if (flag) {
            if (array[i] > array[i + 1]) {
                array[i] = array[i + 1].also { array[i + 1] = array[i] }
            }
        } else {
            if (array[i] < array[i + 1]) {
                array[i] = array[i + 1].also { array[i + 1] = array[i] }
            }
        }
        flag = !flag
    }
}
