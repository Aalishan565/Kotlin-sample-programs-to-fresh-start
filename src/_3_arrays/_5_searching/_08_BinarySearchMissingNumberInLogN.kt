package _3_arrays._5_searching

/**
 * _08_BinarySearchMissingNumberInLogN.kt
 * Finds the missing element in a sorted arithmetic array in O(log N) time.
 *
 * Beginner Explanation:
 * In a sorted sequence starting at 1, `array[i] == i + 1`.
 * Binary search checks if `array[mid] == mid + 1`. If true, missing number is on the right.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 4, 6)

    println("--- Missing Number in Sorted Array (O(log N)) ---")
    println("Sorted Array: ${array.joinToString(", ")}")

    val missing = findMissingInSorted(array)
    println("Missing Number: $missing")
}

fun findMissingInSorted(array: IntArray): Int {
    var low = 0
    var high = array.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2

        if (array[mid] == mid + 1) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return low + 1
}
