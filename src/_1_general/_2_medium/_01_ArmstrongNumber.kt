package _1_general._2_medium

import kotlin.math.pow

/**
 * _01_ArmstrongNumber.kt
 * Checks whether an integer is an Armstrong Number (Narcissistic Number).
 *
 * Definition:
 * An n-digit number is an Armstrong number if the sum of its digits raised to the power n equals the original number.
 * Examples: 153 (1^3 + 5^3 + 3^3 = 153), 1634 (1^4 + 6^4 + 3^4 + 4^4 = 1634).
 *
 * Time Complexity: O(d) where d is digit count
 * Space Complexity: O(1)
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

fun isArmstrongNumberFunctional(inputNumber: Int): Boolean {
    if (inputNumber < 0) return false

    val str = inputNumber.toString()
    val numberOfDigits = str.length

    val sum = str.sumOf { char ->
        char.digitToInt().toDouble().pow(numberOfDigits.toDouble()).toInt()
    }
    return sum == inputNumber
}
