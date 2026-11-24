package _1_general._2_medium

/**
 * _02_Factorial.kt
 * Calculates the Factorial of a non-negative integer n (n!).
 *
 * Approaches:
 * 1. Iterative Loop: O(N) Time, O(1) Space.
 * 2. Recursion: O(N) Time, O(N) Call Stack.
 * 3. Kotlin `tailrec`: Compiles recursion into a flat loop at compile-time to prevent StackOverflowError.
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

fun factorialUsingLoop(number: Int): Long {
    if (number < 0) return -1L
    var result = 1L
    for (i in 1..number) {
        result *= i
    }
    return result
}

fun factorialUsingRecursion(number: Int): Long {
    if (number < 0) return -1L
    if (number == 0 || number == 1) return 1L
    return number * factorialUsingRecursion(number - 1)
}

tailrec fun factorialTailRec(number: Int, accumulator: Long = 1L): Long {
    if (number < 0) return -1L
    if (number == 0 || number == 1) return accumulator
    return factorialTailRec(number - 1, number * accumulator)
}
