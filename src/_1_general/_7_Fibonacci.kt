package _1_general

/**
 * _7_Fibonacci.kt
 * Demonstrates generating the Fibonacci series and calculating the N-th Fibonacci number.
 *
 * Definition:
 *   The Fibonacci sequence starts with 0 and 1, where each subsequent number is the sum of the previous two numbers:
 *   F(0) = 0, F(1) = 1
 *   F(n) = F(n - 1) + F(n - 2) for n >= 2
 *
 * Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
 */
fun main() {
    val n = 7
    println("--- Fibonacci Series up to $n terms ---")
    val series = generateFibonacciSeries(n)
    println("Series (first $n terms): $series")

    println("\n--- N-th Fibonacci Number (n = $n) ---")
    println("Iterative (Loop):  F($n) = ${fibonacciNthIterative(n)}")
    println("Recursive (Fixed): F($n) = ${fibonacciNthRecursiveNumber(n)}")
}
/**
 * Generates and returns a List of the first `count` Fibonacci numbers.
 * Time Complexity: O(N), Space Complexity: O(N)
 */
fun generateFibonacciSeries(count: Int): List<Long> {
    if (count <= 0) return emptyList()
    if (count == 1) return listOf(0L)
    val series = mutableListOf(0L, 1L)
    for (step in 3..count) {
        val nextNumber = series[series.size - 1] + series[series.size - 2]
        series.add(nextNumber)
    }
    return series
}

/**
 * Approach 1: Iterative N-th Fibonacci Number (O(N) Time, O(1) Space)
 * Calculates F(n) using two running variables.
 */
fun fibonacciNthIterative(n: Int): Long {
    if (n < 0) return -1L
    if (n == 0) return 0L
    if (n == 1) return 1L

    var first = 0L
    var second = 1L
    var result = 0L

    for (step in 2..n) {
        result = first + second
        first = second
        second = result
    }
    return result
}

private fun fibonacciNthRecursiveNumber(number: Int): Int {
    if (number < 0) return -1
    if (number == 0) return 0
    if (number == 1) return 1
    return fibonacciNthRecursiveNumber(number - 1) + fibonacciNthRecursiveNumber(number - 2)
}