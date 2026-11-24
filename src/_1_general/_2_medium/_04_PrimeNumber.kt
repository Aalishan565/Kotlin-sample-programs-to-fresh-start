package _1_general._2_medium

/**
 * _04_PrimeNumber.kt
 * Checks if a number is prime and prints prime numbers up to N using O(sqrt(N)) trial division.
 *
 * Time Complexity: O(sqrt(N)) for single prime check
 * Space Complexity: O(1)
 */
fun main() {
    val number = 29

    println("--- Prime Number Checker ---")
    println("Is $number prime? ${isPrimeNumber(number)}")

    println("\nPrime numbers up to 30:")
    printAllPrimeNumbers(30)
}

fun isPrimeNumber(number: Int): Boolean {
    if (number <= 1) return false

    var i = 2
    while (i * i <= number) {
        if (number % i == 0) {
            return false
        }
        i++
    }
    return true
}

fun printAllPrimeNumbers(limit: Int) {
    for (num in 2..limit) {
        if (isPrimeNumber(num)) {
            print("$num ")
        }
    }
    println()
}
