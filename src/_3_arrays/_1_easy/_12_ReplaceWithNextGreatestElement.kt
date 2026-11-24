package _3_arrays._1_easy

/**
 * _12_ReplaceWithNextGreatestElement.kt
 * Replaces each element in an array with the greatest element on its right side.
 *
 * Beginner Explanation:
 * Iterate backwards from right to left while keeping track of `maxFromRight`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(2, 1, 2, 1, 0, 4, 1, 0, 1, 2)

    println("--- Replace Elements with Greatest Element on Right ---")
    println("Original Array: ${array.joinToString(", ")}")

    replaceWithNextGreatest(array)
    println("Replaced Array: ${array.joinToString(", ")}")
}

fun replaceWithNextGreatest(array: IntArray) {
    if (array.isEmpty()) return

    var maxFromRight = array[array.size - 1]

    for (i in array.size - 2 downTo 0) {
        if (maxFromRight >= array[i]) {
            array[i] = maxFromRight
        } else {
            maxFromRight = array[i]
        }
    }
}
