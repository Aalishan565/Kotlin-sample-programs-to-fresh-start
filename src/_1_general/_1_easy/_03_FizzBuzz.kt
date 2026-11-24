package _1_general._1_easy

/**
 * _03_FizzBuzz.kt
 * Prints numbers 1 to N, replacing multiples of 3 with "Fizz", multiples of 5 with "Buzz",
 * and multiples of both 3 and 5 with "FizzBuzz" (LeetCode #412).
 *
 * Beginner Explanation:
 * - Check `i % 15 == 0` (or `i % 3 == 0 && i % 5 == 0`) first for "FizzBuzz".
 * - Check `i % 3 == 0` for "Fizz".
 * - Check `i % 5 == 0` for "Buzz".
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    println("--- FizzBuzz (1 to 20) ---")
    fizzBuzz(20)
}

fun fizzBuzz(limit: Int) {
    for (i in 1..limit) {
        val result = when {
            i % 15 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> i.toString()
        }
        println(result)
    }
}
