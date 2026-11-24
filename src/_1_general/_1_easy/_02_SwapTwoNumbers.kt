package _1_general._1_easy

/**
 * _02_SwapTwoNumbers.kt
 * Demonstrates various methods to swap two numbers in Kotlin.
 *
 * Approaches:
 * 1. Using a Temporary Variable (Most readable & standard).
 * 2. Without Third Variable using Arithmetic (Addition & Subtraction).
 * 3. Without Third Variable using Bitwise XOR (`xor`).
 * 4. Idiomatic Kotlin syntax using `.also`.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
fun main() {
    val a = 10
    val b = 5

    println("Original Values: a = $a, b = $b\n")

    println("--- 1. Using Temporary Variable ---")
    swapWithTempVariable(a, b)

    println("\n--- 2. Without Third Variable (Arithmetic Addition/Subtraction) ---")
    swapWithoutThirdVariable(a, b)

    println("\n--- 3. Without Third Variable (Bitwise XOR) ---")
    swapUsingXor(a, b)

    println("\n--- 4. Idiomatic Kotlin Way (.also) ---")
    swapIdiomaticKotlin(a, b)
}

fun swapWithTempVariable(inputA: Int, inputB: Int) {
    var num1 = inputA
    var num2 = inputB
    val temp = num1
    num1 = num2
    num2 = temp
    println("Swapped: a = $num1, b = $num2")
}

fun swapWithoutThirdVariable(inputA: Int, inputB: Int) {
    var num1 = inputA
    var num2 = inputB
    num1 += num2
    num2 = num1 - num2
    num1 -= num2
    println("Swapped: a = $num1, b = $num2")
}

fun swapUsingXor(inputA: Int, inputB: Int) {
    var num1 = inputA
    var num2 = inputB
    num1 = num1 xor num2
    num2 = num1 xor num2
    num1 = num1 xor num2
    println("Swapped: a = $num1, b = $num2")
}

fun swapIdiomaticKotlin(inputA: Int, inputB: Int) {
    var num1 = inputA
    var num2 = inputB
    num1 = num2.also { num2 = num1 }
    println("Swapped: a = $num1, b = $num2")
}
