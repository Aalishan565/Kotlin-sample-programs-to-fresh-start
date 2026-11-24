package _1_general._2_medium

/**
 * _03_Fibonacci.kt
 * Generates the Fibonacci series and calculates the N-th Fibonacci number.
 * Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
 *
 * Time Complexity: O(N) Iterative
 * Space Complexity: O(1) Iterative, O(N) Series
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

fun generateFibonacciSeries(count: Int): List<Long> {
    if (count <= 0) return emptyList()
    if (count == 1) return listOf(0L)
    val series = mutableListOf(0L, 1L)
    repeat(count - 2) {
        val nextNumber = series[series.size - 1] + series[series.size - 2]
        series.add(nextNumber)
    }
    return series
}

fun fibonacciNthIterative(n: Int): Long {
    if (n < 0) return -1L
    if (n == 0) return 0L
    if (n == 1) return 1L

    var first = 0L
    var second = 1L
    var result = 0L

    repeat(n - 1) {
        result = first + second
        first = second
        second = result
    }
    return result
}

fun fibonacciNthRecursiveNumber(number: Int): Int {
    if (number < 0) return -1
    if (number == 0) return 0
    if (number == 1) return 1
    return fibonacciNthRecursiveNumber(number - 1) + fibonacciNthRecursiveNumber(number - 2)
}
