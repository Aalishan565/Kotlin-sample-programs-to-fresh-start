package _0_kotlin_basics

/**
 * 25LazyKotlinNullSafety.kt
 * Demonstrates Lazy Property Evaluation using `by lazy` delegate in Kotlin.
 *
 * Key Concepts:
 * 1. `by lazy { ... }`: Property initialization is deferred until the first time it is accessed in code.
 * 2. Thread Safety: By default, `lazy` properties are synchronized and thread-safe.
 * 3. Works only with `val` (read-only properties).
 */
fun main() {
    println("--- Kotlin Lazy Initialization ---")

    // Memory is NOT allocated and lambda block is NOT executed until first access
    val lazyMessage: String by lazy {
        println("--> Executing heavy lazy initialization block...")
        "Hello! This string was lazily initialized."
    }

    println("Variable `lazyMessage` declared (not yet accessed).")

    println("\nFirst access to `lazyMessage`:")
    println(lazyMessage) // Triggers initialization

    println("\nSecond access to `lazyMessage`:")
    println(lazyMessage) // Uses cached value without re-evaluating block
}
