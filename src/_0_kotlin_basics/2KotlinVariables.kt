package _0_kotlin_basics

/**
 * 2KotlinVariables.kt
 * Demonstrates variable declarations, mutability, type inference, constants, and string interpolation in Kotlin.
 *
 * Key Concepts:
 * 1. `var` (Mutable): Variables whose value can be reassigned at runtime.
 * 2. `val` (Immutable): Read-only variables (similar to `final` in Java). Value cannot be changed once assigned.
 * 3. `const val` (Compile-time constant): Declared at top-level or in objects; value must be known at compile time.
 * 4. Type Inference: Kotlin automatically infers types based on assigned values, but explicit type annotations (e.g. `String`) are supported.
 * 5. String Interpolation: Expression evaluation inside strings using `$variableName` or `${expression}`.
 */

// Top-level compile-time constant (allocated/evaluated at compile time)
const val ID = 101

fun main() {
    println("--- Kotlin Variables & Mutability ---")

    // 1. Mutable variable (`var`)
    var name = "XYZ"
    println("Initial name (var): $name")
    name = "John Doe" // Reassignment allowed
    println("Reassigned name (var): $name")

    // 2. Immutable variable (`val`) - evaluated at runtime
    val age = 27
    // age = 28 // Error: Val cannot be reassigned
    println("Age (val): $age")

    // 3. Explicit Type Annotation
    var myName: String = "Abc"
    println("Explicitly typed variable: $myName")

    // 4. Traditional Java String Concatenation vs Kotlin String Interpolation
    println("\n--- String Concatenation vs Interpolation ---")
    println("Traditional Concatenation: My name is " + name + " and my age is " + age)
    println("Kotlin String Interpolation: My name is $name and my age is $age")
    println("Expression Interpolation: Next year age will be ${age + 1}")

    // 5. Accessing Top-Level Constant
    println("\n--- Compile-Time Constant ---")
    println("Constant ID: $ID")
}