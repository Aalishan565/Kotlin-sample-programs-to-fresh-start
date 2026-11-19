package _0_kotlin_basics

/**
 * 8KotlinFunctions.kt
 * Demonstrates basic function declarations, default arguments, named parameters, return types, and vararg parameters in Kotlin.
 *
 * Key Concepts:
 * 1. Simple Function: Declared using `fun` keyword.
 * 2. Parameterized Function: Accepts parameters with explicit types.
 * 3. Return Types & `Unit`: Functions without explicit return values implicitly return `Unit` (similar to `void` in Java).
 * 4. Named Arguments: Pass arguments by parameter name for readability or to reorder arguments.
 * 5. Default Argument Values: Allows calling functions with omitted parameters.
 * 6. `vararg` Parameters: Accepts a variable number of arguments of the specified type.
 */
fun main() {
    println("--- 1. Simple No-Argument Function ---")
    printName()

    println("\n--- 2. Parameterized Function ---")
    paramFunction("Kotlin Basics")

    println("\n--- 3. Function with Parameters & Return Value ---")
    val result = sum(3, 5)
    println("Sum of 3 and 5 = $result")

    println("\n--- 4. Function with Named Arguments ---")
    val namedResult = sum(number2 = 12, number1 = 8)
    println("Named arguments sum (number2 = 12, number1 = 8) = $namedResult")

    println("\n--- 5. Unit Returning Function ---")
    printAverage(10.0, 2.0)

    println("\n--- 6. Default Argument Values ---")
    displayGreeting("Welcome") // Uses default parameter for `name`
    displayGreeting("Good Morning", "Alice") // Overrides default parameter

    println("\n--- 7. Vararg Function (Variable Number of Arguments) ---")
    val sumNumbers = sumOfNumbers(1, 2, 3, 4, 5)
    println("Sum of (1, 2, 3, 4, 5) = $sumNumbers")
}

// Simple function
fun printName() {
    println("This is the printName() function.")
}

// Parameterized function
fun paramFunction(name: String) {
    println("This is the paramFunction() receiving parameter: '$name'")
}

// Function with parameters and return type Int
fun sum(number1: Int, number2: Int): Int {
    return number1 + number2
}

// Function explicitly declaring Unit return type (void equivalent)
fun printAverage(a: Double, b: Double): Unit {
    val avg = (a + b) / 2
    println("Average of ($a, $b) = $avg")
}

// Function with default parameter values
fun displayGreeting(message: String, name: String = "Guest") {
    println("Hello $name, $message!")
}

// Function accepting variable number of arguments (`vararg`)
fun sumOfNumbers(vararg numbers: Int): Int {
    var sum = 0
    for (number in numbers) {
        sum += number
    }
    return sum
}
