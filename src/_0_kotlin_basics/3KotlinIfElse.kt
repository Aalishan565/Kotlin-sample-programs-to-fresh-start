package _0_kotlin_basics

/**
 * 3KotlinIfElse.kt
 * Demonstrates conditional statements (`if-else`) in Kotlin.
 *
 * Key Concepts:
 * 1. Traditional `if-else` statement: Used as a control statement to execute blocks of code.
 * 2. `if-else` as an Expression: In Kotlin, `if-else` can return a value directly (replacing the Java ternary operator `condition ? a : b`).
 * 3. Multi-branch `if-else`: Chaining multiple conditions together.
 */
fun main() {
    val num1 = 2
    val num2 = 5

    println("--- 1. Traditional If-Else Statement ---")
    if (num1 > num2) {
        println("Bigger number is $num1")
    } else {
        println("Bigger number is $num2")
    }

    println("\n--- 2. Single-Line If-Else Statement ---")
    if (num1 > num2) println("Bigger number is $num1") else println("Bigger number is $num2")

    println("\n--- 3. If-Else as an Expression (Assigning Result) ---")
    // In Kotlin, the last expression in an if-else block is returned as its value
    val biggerNumber = if (num1 > num2) num1 else num2
    println("Bigger number returned from expression: $biggerNumber")

    println("\n--- 4. Multi-Branch If-Else Expression ---")
    evaluateComparison(10, 20)
    evaluateComparison(15, 5)
    evaluateComparison(7, 7)
}

fun evaluateComparison(a: Int, b: Int) {
    val result = if (a > b) {
        "a ($a) is greater than b ($b)"
    } else if (a < b) {
        "a ($a) is smaller than b ($b)"
    } else {
        "a ($a) and b ($b) are equal"
    }
    println("Result ($a vs $b): $result")
}
