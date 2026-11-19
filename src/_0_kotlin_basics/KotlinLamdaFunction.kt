package _0_kotlin_basics

/**
 * KotlinLamdaFunction.kt
 * Demonstrates Higher-Order Functions and Lambda Expressions in Kotlin.
 *
 * Key Concepts:
 * 1. Lambda Expression: An anonymous function stored in a variable or passed as an expression: `{ a: Int, b: Int -> a + b }`.
 * 2. Higher-Order Function: A function that takes another function as a parameter or returns a function.
 * 3. Function Type Syntax: `(Int, Int) -> Int` specifies a function signature taking two `Int` parameters and returning an `Int`.
 */
fun main() {
    println("--- Kotlin Lambdas & Higher-Order Functions ---")

    // 1. Invoking a lambda directly stored in a variable
    val sum = add(10, 20)
    println("Direct lambda invocation (add): 10 + 20 = $sum")

    // 2. Passing lambda as an argument to a higher-order function
    val res = calculateSum(10, 20, add)
    println("Higher-order function result (calculateSum): $res")

    // 3. Passing an inline lambda expression directly
    val multiplyResult = calculateOperation(5, 4) { x, y -> x * y }
    println("Higher-order function with inline lambda (multiply): 5 * 4 = $multiplyResult")
}

// Lambda variable taking two Ints and returning an Int
val add: (Int, Int) -> Int = { a: Int, b: Int -> a + b }

// Higher-order function accepting a lambda parameter `op`
fun calculateSum(a: Int, b: Int, op: (a: Int, b: Int) -> Int): Int {
    return op(a, b)
}

// Generic higher-order function executing custom arithmetic operation
fun calculateOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}
