package _1_general

/**
 * _11_SwapTwoNumbers.kt
 * Demonstrates various methods to swap two numbers in Kotlin.
 *
 * Approaches:
 * 1. Using a Temporary Variable (Most readable & standard).
 * 2. Without Third Variable using Arithmetic (Addition & Subtraction).
 * 3. Without Third Variable using Bitwise XOR (`xor`).
 * 4. Idiomatic Kotlin syntax using `.also`.
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

/**
 * Method 1: Using Temporary Variable
 * Simple, clean, and avoids integer overflow risks.
 */
fun swapWithTempVariable(inputA: Int, inputB: Int) {
    var num1 = inputA
    var num2 = inputB
    val temp = num1
    num1 = num2
    num2 = temp
    println("Swapped: a = $num1, b = $num2")
}

/**
 * Method 2: Without Third Variable using Arithmetic (+ and -)
 * Logic:
 *   num1 = num1 + num2 (10 + 5 = 15)
 *   num2 = num1 - num2 (15 - 5 = 10)
 *   num1 = num1 - num2 (15 - 10 = 5)
 */
fun swapWithoutThirdVariable(inputA: Int, inputB: Int) {
    var num1 = inputA
    var num2 = inputB
    num1 += num2
    num2 = num1 - num2
    num1 -= num2

    println("Swapped: a = $num1, b = $num2")
}

/**
 * Method 3: Without Third Variable using Bitwise XOR (`xor`)
 * Logic:
 *   x ^ x = 0, x ^ 0 = x
 */
fun swapUsingXor(inputA: Int, inputB: Int) {
    var num1 = inputA
    var num2 = inputB

    num1 = num1 xor num2
    num2 = num1 xor num2
    num1 = num1 xor num2

    println("Swapped: a = $num1, b = $num2")
}

/**
 * Method 4: Idiomatic Kotlin Way (`.also`)
 * Swaps two variables in a single expression.
 */
fun swapIdiomaticKotlin(inputA: Int, inputB: Int) {
    var num1 = inputA
    var num2 = inputB

    num1 = num2.also { num2 = num1 }

    println("Swapped: a = $num1, b = $num2")
}
