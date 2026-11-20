package _1_general

/**
 * _6_Factorial.kt
 * Calculates the Factorial of a non-negative integer n (n!).
 *
 * Definition:
 *   n! = n * (n - 1) * (n - 2) * ... * 1
 *   0! = 1
 *
 * Edge Cases Handled:
 * 1. n = 0: 0! is 1.
 * 2. n < 0: Factorial is undefined for negative integers; return -1.
 * 3. Return type Long: Uses 64-bit Long to support factorials up to 20! without integer overflow.
 */
fun main() {
    val testNumbers = listOf(0, 5, 10, 13, -3)

    println("--- Factorial Calculation ---")
    for (n in testNumbers) {
        val loopResult = factorialUsingLoop(n)
        val recResult = factorialUsingRecursion(n)
        val tailRecResult = factorialTailRec(n)

        println("n = ${n.toString().padStart(2)} -> Loop: ${loopResult.toString().padStart(10)} | Recursion: ${recResult.toString().padStart(10)} | TailRec: ${tailRecResult.toString().padStart(10)}")
    }
}

/**
 * Approach 1: Iterative Loop (O(N) Time, O(1) Space)
 * Multiplies numbers from 1 to n.
 */
fun factorialUsingLoop(number: Int): Long {
    if (number < 0) return -1L
    var result = 1L
    for (i in 1..number) {
        result *= i
    }
    return result
}

/**
 * Approach 2: Standard Recursion (O(N) Time, O(N) Call Stack)
 * n! = n * (n - 1)!
 */
fun factorialUsingRecursion(number: Int): Long {
    if (number < 0) return -1L
    if (number == 0 || number == 1) return 1L
    return number * factorialUsingRecursion(number - 1)
}

/**
 * Approach 3: Kotlin Tail-Recursive Approach (O(N) Time, O(1) Call Stack)
 * Uses `tailrec` modifier to optimize recursion into a flat loop at compile-time, preventing StackOverflowError.
 */
tailrec fun factorialTailRec(number: Int, accumulator: Long = 1L): Long {
    if (number < 0) return -1L
    if (number == 0 || number == 1) return accumulator
    return factorialTailRec(number - 1, number * accumulator)
}
