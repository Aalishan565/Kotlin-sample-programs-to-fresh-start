package _1_general

import kotlin.math.pow

/**
 * _3_ArmstrongNumber.kt
 * Checks whether a given integer is an Armstrong Number (Narcissistic Number).
 *
 * Definition:
 * An n-digit number is an Armstrong number if the sum of its digits,
 * each raised to the power of n, equals the original number.
 *
 * Examples:
 *   - 153  (3 digits): 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153  (Armstrong)
 *   - 1634 (4 digits): 1^4 + 6^4 + 3^4 + 4^4 = 1 + 1296 + 81 + 256 = 1634 (Armstrong)
 *   - 123  (3 digits): 1^3 + 2^3 + 3^3 = 1 + 8 + 27 = 36 != 123 (Not Armstrong)
 */
fun main() {
    val testNumbers = listOf(153, 370, 1634, 123)
    println("--- Armstrong Number Checker ---")
    for (number in testNumbers) {
        val resultMathematical = isArmstrongNumber(number)
        val resultFunctional = isArmstrongNumberFunctional(number)
        println("Number: $number -> Is Armstrong? $resultMathematical (Functional check: $resultFunctional)")
    }
}

/**
 * Approach 1: Mathematical Loop Approach (Most Efficient, O(d) space/time where d is digits count)
 * 1. Count the number of digits in input.
 * 2. Extract digits one by one using modulo (`% 10`).
 * 3. Add (digit ^ numberOfDigits) to the sum.
 * 4. Divide number by 10 (`/ 10`) until 0.
 */
fun isArmstrongNumber(inputNumber: Int): Boolean {
    if (inputNumber < 0) return false

    val numberOfDigits = inputNumber.toString().length
    var number = inputNumber
    var sum = 0

    while (number > 0) {
        val reminder = number % 10
        sum += reminder.toDouble().pow(numberOfDigits.toDouble()).toInt()
        number /= 10
    }
    return sum == inputNumber
}

/**
 * Approach 2: Idiomatic Kotlin Way (Short & Easy to Read)
 * Uses String mapping and `sumOf` to calculate the power of each digit.
 */
fun isArmstrongNumberFunctional(inputNumber: Int): Boolean {
    if (inputNumber < 0) return false

    val str = inputNumber.toString()
    val numberOfDigits = str.length

    val sum = str.sumOf { char ->
        char.digitToInt().toDouble().pow(numberOfDigits.toDouble()).toInt()
    }
    return sum == inputNumber
}