package _0_kotlin_basics

/**
 * 24KotlinNullSafety.kt
 * Demonstrates Null Safety features and operators in Kotlin.
 *
 * Key Concepts:
 * 1. Nullable Types (`Type?`): Variables that can explicitly hold `null`.
 * 2. Safe Call Operator (`?.`): Safely accesses properties/methods; evaluates to `null` if the reference is null.
 * 3. Safe Call with `let` (`?.let { ... }`): Executes block only if receiver is non-null.
 * 4. Elvis Operator (`?:`): Provides a default fallback value if expression on the left is `null`.
 * 5. Not-Null Assertion Operator (`!!`): Converts any value to a non-null type; throws `NullPointerException` if null.
 */
fun main() {
    println("--- Kotlin Null Safety ---")

    demonstrateNullSafety("Abcd")
    println("-----------------------------------")
    demonstrateNullSafety(null)
}

fun demonstrateNullSafety(name: String?) {
    println("\nDemonstrating with input: $name")

    // 1. Safe Call Operator (`?.`)
    println("1. Safe Call Operator (?.): name?.length = ${name?.length}")

    // 2. Safe Call with `let` (`?.let`)
    println("2. Safe Call with let (?.let):")
    name?.let {
        println("   Inside let block - length of '$it' is ${it.length}")
    } ?: println("   Inside let block - Skipping because input is null")

    // 3. Elvis Operator (`?:`)
    val length = name?.length ?: -1
    println("3. Elvis Operator (?:): Calculated length (or fallback -1) = $length")

    // 4. Not-Null Assertion Operator (`!!`)
    try {
        println("4. Asserted non-null length (!!): ${name!!.length}")
    } catch (e: NullPointerException) {
        println("4. Asserted non-null (!!): Caught expected NullPointerException (${e.javaClass.simpleName})!")
    }
}
